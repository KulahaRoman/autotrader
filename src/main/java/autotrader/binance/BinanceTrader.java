package autotrader.binance;

import autotrader.binance.model.Candle;
import autotrader.binance.model.Order;
import autotrader.binance.model.exchange.symbol.filter.FilterType;
import autotrader.binance.model.exchange.symbol.filter.LotSizeFilter;
import autotrader.binance.model.exchange.symbol.filter.PriceFilter;
import autotrader.binance.model.update.OrderUpdate;
import autotrader.binance.model.update.Update;
import autotrader.binance.util.Numbers;
import autotrader.binance.util.Orders;
import autotrader.core.DynamicTrader;
import autotrader.core.Market;
import autotrader.core.UpdateSource;
import lombok.extern.slf4j.Slf4j;

import java.math.RoundingMode;

@Slf4j
public class BinanceTrader implements DynamicTrader<Candle> {
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
                if (updateSource.nextUpdate() instanceof OrderUpdate update) {
                    log.trace("Order update received: {}", update.getType());
                    try {
                        handleUpdate(update);
                    } catch (Exception e) {
                        log.error("Failed to handle order update", e);
                    }
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

            log.trace("LotSize filter:");
            log.trace("minQty={}", amountFilter.getMinQuantity());
            log.trace("maxQty={}", amountFilter.getMaxQuantity());
            log.trace("stepSize={}", amountFilter.getStepSize());

            var symbol = scalperState.getSymbol().getName();
            var free = traderState.getBaseAssetBalance().getFree() / 3;
            var amount = Numbers.round(free / candle.getClosePrice(),
                    amountFilter.getStepSize(), RoundingMode.UP);

            log.trace("Buy order arguments:");
            log.trace("symbol={}", symbol);
            log.trace("free={}", free);
            log.trace("amount={}", amount);

            try {
                var request = Orders.createBuyOrder(symbol, amount);
                var response = market.placeOrder(request);

                var trade = new Trade();
                trade.setSymbol(symbol);
                trade.setAmount(amount);
                trade.setPrice(candle.getClosePrice());

                var context = new Context();
                context.setBuyOrder(response);

                traderState.setTrade(trade);
                traderState.setPhase(Phase.NEW);
                traderState.setContext(context);
            } catch (Exception e) {
                log.warn("Failed to create buy order", e);

                traderState.setTrade(null);
                traderState.setPhase(null);
                traderState.setContext(null);
            }
        } else if (traderState.getPhase() == Phase.BOUGHT) {
            var stopLossOrder = traderState.getContext().getStopLossOrder();
            if (stopLossOrder != null) {
                market.cancelOrder(stopLossOrder);
            }
            placeStopLoss(candle.getClosePrice());
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

            log.trace("LotSize filter:");
            log.trace("minQty={}", amountFilter.getMinQuantity());
            log.trace("maxQty={}", amountFilter.getMaxQuantity());
            log.trace("stepSize={}", amountFilter.getStepSize());

            var symbol = traderState.getTrade().getSymbol();
            var free = traderState.getQuoteAssetBalance().getFree();
            var amount = Math.min(Math.max(free, amountFilter.getMinQuantity()), amountFilter.getMaxQuantity());
            var rounded = Numbers.round(amount, amountFilter.getStepSize(), RoundingMode.DOWN);

            log.trace("Sell order arguments:");
            log.trace("symbol={}", symbol);
            log.trace("free={}", free);
            log.trace("amount={}", amount);
            log.trace("rounded={}", rounded);

            try {
                var request = Orders.createSellOrder(symbol, rounded);
                var response = market.placeOrder(request);

                traderState.getContext().setSellOrder(response);
            } catch (Exception e) {
                log.warn("Failed to create sell order", e);
            }
        }
    }

    @Override
    public void handleCandleSignal(Candle candle) {
        log.trace("handleCandleSignal candle {}", candle);
        log.trace("trader phase: {}", traderState.getPhase() == null ? "null" : traderState.getPhase());

        if (traderState.getPhase() == Phase.BOUGHT) {
            var stopLossOrder = traderState.getContext().getStopLossOrder();
            if (stopLossOrder != null) {
                market.cancelOrder(stopLossOrder);
            }
            placeStopLoss(candle.getClosePrice());
        }
    }

    private void handleUpdate(OrderUpdate update) {
        log.trace("handleUpdate update {}", update.getType());
        
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
                            var entryPrice = traderState.getTrade().getPrice();
                            log.info("Trade was opened at price {}.", entryPrice);

                            traderState.setPhase(Phase.BOUGHT);

                            //placeStopLoss(entryPrice * 0.997);
                        }
                    }
                }
            }

            var stopLossOrder = traderState.getContext().getStopLossOrder();
            if (stopLossOrder != null && stopLossOrder.getOrderID() == update.getOrderID()) {
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

                            if (stopLossOrder != null) {
                                market.cancelOrder(stopLossOrder);
                            }

                            traderState.setPhase(Phase.SOLD);
                        }
                    }
                }
            }
        }
    }

    private void placeStopLoss(double latestPrice) {
        var priceFilter = (PriceFilter) scalperState.getSymbol().getFilters().stream()
                .filter(f -> f.getFilterType().equals(FilterType.PRICE_FILTER))
                .findFirst().orElseThrow(() -> new RuntimeException("PRICE filter doesn't exist."));

        log.trace("Price filter:");
        log.trace("minPrice={}", priceFilter.getMinPrice());
        log.trace("maxPrice={}", priceFilter.getMaxPrice());
        log.trace("tickSize={}", priceFilter.getTickSize());

        var amountFilter = (LotSizeFilter) scalperState.getSymbol().getFilters().stream()
                .filter(f -> f.getFilterType().equals(FilterType.LOT_SIZE))
                .findFirst().orElseThrow(() -> new RuntimeException("LOT_SIZE filter doesn't exist."));

        log.trace("LotSize filter:");
        log.trace("minQty={}", amountFilter.getMinQuantity());
        log.trace("maxQty={}", amountFilter.getMaxQuantity());
        log.trace("stepSize={}", amountFilter.getStepSize());

        var symbol = traderState.getTrade().getSymbol();

        // calculating asset amount
        var freeAmount = traderState.getQuoteAssetBalance().getFree();
        var roundedAmount = Numbers.round(freeAmount, amountFilter.getStepSize(), RoundingMode.DOWN);
        var amount = Math.min(Math.max(roundedAmount, amountFilter.getMinQuantity()), amountFilter.getMaxQuantity());

        // calculating asset price
        var entryPrice = traderState.getTrade().getPrice();
        var diffPrice = latestPrice - entryPrice;
        var roundedPrice = Numbers.round(entryPrice + 0.6 * diffPrice,
                priceFilter.getTickSize(), RoundingMode.DOWN);
        var price = Math.min(Math.max(roundedPrice, priceFilter.getMinPrice()), priceFilter.getMaxPrice());

        log.trace("Stop-loss order arguments:");
        log.trace("symbol={}", symbol);
        log.trace("freeAmount={}", freeAmount);
        log.trace("roundedAmount={}", roundedAmount);
        log.trace("amount={}", amount);
        log.trace("entryPrice={}", entryPrice);
        log.trace("diffPrice={}", diffPrice);
        log.trace("roundedPrice={}", roundedPrice);
        log.trace("price={}", price);

        // proceeding request
        try {
            var request = Orders.createStopLossOrder(symbol, amount, price);
            var response = market.placeOrder(request);

            traderState.getContext().setStopLossOrder(response);
        } catch (Exception e) {
            log.warn("Failed to place STOP LOSS order", e);
        }
    }
}
