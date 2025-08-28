package autotrader.binance;

import autotrader.binance.model.Candle;
import autotrader.binance.model.Order;
import autotrader.binance.model.exchange.symbol.filter.FilterType;
import autotrader.binance.model.exchange.symbol.filter.LotSizeFilter;
import autotrader.binance.model.exchange.symbol.filter.TrailingDeltaFilter;
import autotrader.binance.model.update.AccountUpdate;
import autotrader.binance.model.update.OrderUpdate;
import autotrader.binance.model.update.Update;
import autotrader.binance.util.Numbers;
import autotrader.binance.util.Orders;
import autotrader.core.Market;
import autotrader.core.Trader;
import autotrader.core.UpdateSource;
import lombok.extern.slf4j.Slf4j;

import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class BinanceTrader implements Trader<Candle> {
    private final Market<Order> market;

    private final ScalperState scalperState;
    private final TraderState traderState;

    public BinanceTrader(UpdateSource<Update> updateSource, Market<Order> market,
                         ScalperState scalperState, TraderState traderState) {
        this.market = market;

        this.scalperState = scalperState;
        this.traderState = traderState;

        Thread.ofPlatform().start(() -> {
            while (true) {
                var update = updateSource.nextUpdate();

                log.trace("update={}", update);
                log.trace("state={}", traderState);

                try {
                    if (update instanceof OrderUpdate orderUpdate) {
                        handleUpdate(orderUpdate);
                    }
                    if (update instanceof AccountUpdate accountUpdate) {
                        handleUpdate(accountUpdate);
                    }
                } catch (Exception e) {
                    log.error("Failed to handle update", e);
                }
            }
        });
    }

    @Override
    public void handleBuySignal(Candle candle) {
        log.trace("handleBuySignal candle {}", candle);
        log.trace("trader phase: {}", traderState.getPhase() == null ? "null" : traderState.getPhase());

        if (traderState.getPhase() == null
                || traderState.getPhase() == Phase.SOLD
                || traderState.getPhase() == Phase.FAIL) {
            var amountFilter = (LotSizeFilter) scalperState.getSymbol().getFilters().stream()
                    .filter(f -> f.getFilterType().equals(FilterType.LOT_SIZE))
                    .findFirst().orElseThrow(() -> new RuntimeException("LOT_SIZE filter doesn't exist."));

            log.trace("LOT_SIZE filter:");
            log.trace("minQty={}", amountFilter.getMinQuantity());
            log.trace("maxQty={}", amountFilter.getMaxQuantity());
            log.trace("stepSize={}", amountFilter.getStepSize());

            var symbol = scalperState.getSymbol().getName();
            var free = traderState.getBaseAssetBalance().getFree() / 3;
            var amount = Numbers.round(free / candle.getClosePrice(),
                    amountFilter.getStepSize(), RoundingMode.UP);

            log.trace("BUY order arguments:");
            log.trace("symbol={}", symbol);
            log.trace("free={}", free);
            log.trace("amount={}", amount);

            try {
                var request = Orders.createBuy(symbol, amount);
                var response = market.placeOrder(request);

                var trade = new Trade();
                trade.setSymbol(symbol);
                trade.setAmount(amount);
                trade.setPrice(candle.getClosePrice());

                var context = new Context();
                context.setBuyOrder(response);

                context.setBalanceFuture(new CompletableFuture<>());

                context.setBuyFuture(new CompletableFuture<>());
                context.setTrailingFuture(new CompletableFuture<>());
                context.setSellFuture(new CompletableFuture<>());

                context.setEnterTradeFuture(CompletableFuture.allOf(context.getBuyFuture(), context.getBalanceFuture())
                        .thenRun(this::placeTrailingStop));
                context.setExitTradeFuture(CompletableFuture.anyOf(context.getSellFuture(), context.getTrailingFuture())
                        .thenRun(() -> {
                            var trailingOrder = traderState.getContext().getTrailingOrder();
                            if (trailingOrder != null) {
                                market.cancelOrder(trailingOrder);
                            }
                        }));

                traderState.setTrade(trade);
                traderState.setPhase(Phase.NEW);
                traderState.setContext(context);
            } catch (Exception e) {
                log.warn("Failed to create buy order", e);

                traderState.setTrade(null);
                traderState.setPhase(null);
                traderState.setContext(null);
            }
        }
    }

    @Override
    public void handleSellSignal(Candle candle) {
        log.trace("handleSellSignal candle {}", candle);
        log.trace("trader phase: {}", traderState.getPhase() == null ? "null" : traderState.getPhase());

        if (traderState.getPhase() == Phase.BOUGHT) {
            var amountFilter = (LotSizeFilter) scalperState.getSymbol().getFilters().stream()
                    .filter(f -> f.getFilterType().equals(FilterType.LOT_SIZE))
                    .findFirst().orElseThrow(() -> new RuntimeException("LOT_SIZE filter doesn't exist."));

            log.trace("LOT_SIZE filter:");
            log.trace("minQty={}", amountFilter.getMinQuantity());
            log.trace("maxQty={}", amountFilter.getMaxQuantity());
            log.trace("stepSize={}", amountFilter.getStepSize());

            var symbol = traderState.getTrade().getSymbol();
            var free = traderState.getQuoteAssetBalance().getFree();
            var amount = Math.min(Math.max(free, amountFilter.getMinQuantity()), amountFilter.getMaxQuantity());
            var rounded = Numbers.round(amount, amountFilter.getStepSize(), RoundingMode.DOWN);

            log.trace("SELL order arguments:");
            log.trace("symbol={}", symbol);
            log.trace("free={}", free);
            log.trace("amount={}", amount);
            log.trace("rounded={}", rounded);

            try {
                var request = Orders.createSell(symbol, rounded);
                var response = market.placeOrder(request);

                traderState.getContext().setSellOrder(response);
            } catch (Exception e) {
                log.warn("Failed to create sell order", e);
            }
        }
    }

    private void handleUpdate(OrderUpdate update) {
        if (traderState.getPhase() != null && traderState.getContext() != null) {
            var buyOrder = traderState.getContext().getBuyOrder();
            if (buyOrder != null && buyOrder.getOrderID() == update.getOrderID()) {
                switch (update.getCurrentOrderStatus()) {
                    case NEW -> {
                        log.debug("\"BUY\" order was accepted.");
                    }
                    case CANCELED -> {
                        log.debug("\"BUY\" order was cancelled.");

                        if (traderState.getPhase() == Phase.NEW) {
                            traderState.setPhase(Phase.FAIL);
                        }
                    }
                    case REJECTED -> {
                        log.debug("\"BUY\" order was rejected.");

                        if (traderState.getPhase() == Phase.NEW) {
                            traderState.setPhase(Phase.FAIL);
                        }
                    }
                    case PARTIALLY_FILLED -> {
                        log.debug("\"BUY\" order was partially filled.");
                    }
                    case FILLED -> {
                        log.debug("\"BUY\" order was filled.");

                        if (traderState.getPhase() == Phase.NEW) {
                            log.info("Trade was opened.");

                            traderState.setPhase(Phase.BOUGHT);

                            var buyFuture = traderState.getContext().getBuyFuture();
                            if (buyFuture != null) {
                                buyFuture.complete(null);
                            }
                        }
                    }
                }
            }

            var trailingOrder = traderState.getContext().getTrailingOrder();
            if (trailingOrder != null && trailingOrder.getOrderID() == update.getOrderID()) {
                switch (update.getCurrentOrderStatus()) {
                    case NEW -> {
                        log.debug("\"STOP LOSS\" order was accepted.");
                    }
                    case CANCELED -> {
                        log.debug("\"STOP LOSS\" order was cancelled.");
                    }
                    case REJECTED -> {
                        log.debug("\"STOP LOSS\" order was rejected.");
                    }
                    case PARTIALLY_FILLED -> {
                        log.debug("\"STOP LOSS\" order was partially filled.");
                    }
                    case FILLED -> {
                        log.debug("\"STOP LOSS\" order was filled.");

                        if (traderState.getPhase() == Phase.BOUGHT) {
                            log.info("Trade was closed.");

                            traderState.setPhase(Phase.SOLD);

                            var trailingFuture = traderState.getContext().getTrailingFuture();
                            if (trailingFuture != null) {
                                trailingFuture.complete(null);
                            }
                        }
                    }
                }
            }

            var sellOrder = traderState.getContext().getSellOrder();
            if (sellOrder != null && sellOrder.getOrderID() == update.getOrderID()) {
                switch (update.getCurrentOrderStatus()) {
                    case NEW -> {
                        log.debug("\"SELL\" order was accepted.");
                    }
                    case REJECTED -> {
                        log.debug("\"SELL\" order was rejected.");
                    }
                    case CANCELED -> {
                        log.debug("\"SELL\" order was canceled.");
                    }
                    case PARTIALLY_FILLED -> {
                        log.debug("\"SELL\" order was partially filled.");
                    }
                    case FILLED -> {
                        log.debug("\"SELL\" order was filled.");

                        if (traderState.getPhase() == Phase.BOUGHT) {
                            log.info("Trade was closed.");

                            traderState.setPhase(Phase.SOLD);

                            var sellFuture = traderState.getContext().getSellFuture();
                            if (sellFuture != null) {
                                sellFuture.complete(null);
                            }
                        }
                    }
                }
            }
        }
    }

    private void handleUpdate(AccountUpdate update) {
        update.getBalances().forEach(balance -> {
            if (balance.getAsset().equals(traderState.getBaseAssetBalance().getAsset())) {
                traderState.setBaseAssetBalance(balance);
                log.info("Base asset {} balance updated: {}", balance.getAsset(), balance.getFree());
            }
            if (balance.getAsset().equals(traderState.getQuoteAssetBalance().getAsset())) {
                traderState.setQuoteAssetBalance(balance);
                log.info("Quote asset {} balance updated: {}", balance.getAsset(), balance.getFree());

                var balanceFuture = traderState.getContext().getBalanceFuture();
                if (balanceFuture != null) {
                    balanceFuture.complete(null);
                }
            }
        });
    }

    private void placeTrailingStop() {
        var amountFilter = (LotSizeFilter) scalperState.getSymbol().getFilters().stream()
                .filter(f -> f.getFilterType().equals(FilterType.LOT_SIZE))
                .findFirst().orElseThrow(() -> new RuntimeException("LOT_SIZE filter doesn't exist."));

        log.trace("LOT_SIZE filter:");
        log.trace("minQty={}", amountFilter.getMinQuantity());
        log.trace("maxQty={}", amountFilter.getMaxQuantity());
        log.trace("stepSize={}", amountFilter.getStepSize());

        var trailingFilter = (TrailingDeltaFilter) scalperState.getSymbol().getFilters().stream()
                .filter(f -> f.getFilterType().equals(FilterType.TRAILING_DELTA))
                .findFirst().orElseThrow(() -> new RuntimeException("TRAILING_DELTA filter doesn't exist."));

        log.trace("TRAILING_DELTA filter:");
        log.trace("minTrailingBelowDelta={}", trailingFilter.getMinTrailingBelowDelta());
        log.trace("maxTrailingBelowDelta={}", trailingFilter.getMaxTrailingBelowDelta());

        var symbol = traderState.getTrade().getSymbol();

        // calculating asset amount
        var freeAmount = traderState.getQuoteAssetBalance().getFree();
        var roundedAmount = Numbers.round(freeAmount, amountFilter.getStepSize(), RoundingMode.DOWN);
        var amount = Math.min(Math.max(roundedAmount, amountFilter.getMinQuantity()), amountFilter.getMaxQuantity());

        // calculating trailing delta
        var delta = (int) trailingFilter.getMinTrailingBelowDelta();

        log.trace("STOP LOSS order arguments:");
        log.trace("symbol={}", symbol);
        log.trace("freeAmount={}", freeAmount);
        log.trace("roundedAmount={}", roundedAmount);
        log.trace("amount={}", amount);
        log.trace("delta={}", delta);

        // proceeding request
        try {
            var request = Orders.createTrailingStop(symbol, amount, delta);
            var response = market.placeOrder(request);

            traderState.getContext().setTrailingOrder(response);
        } catch (Exception e) {
            log.warn("Failed to place STOP LOSS order", e);
        }
    }
}
