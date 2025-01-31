package autotrader.binance.handler;

import autotrader.binance.model.Candle;
import autotrader.core.CandleHandler;
import autotrader.core.DynamicTrader;
import autotrader.core.Strategy;
import autotrader.core.Trader;

public class BinanceCandleHandler implements CandleHandler<Candle> {
    private final Strategy<Candle> strategy;
    private final Trader<Candle> trader;

    public BinanceCandleHandler(Strategy<Candle> strategy, DynamicTrader<Candle> trader) {
        this.strategy = strategy;
        this.trader = trader;
    }

    @Override
    public void handleCandle(Candle candle) {
        strategy.getDecision(candle).ifPresent(decision -> {
            switch (decision) {
                case BUY -> trader.handleBuySignal(candle);
                case SELL -> trader.handleSellSignal(candle);
            }
        });
    }
}
