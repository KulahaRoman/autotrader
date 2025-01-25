package autotrader.binance;

import autotrader.binance.model.Candle;
import autotrader.core.CandleHandler;
import autotrader.core.Strategy;
import autotrader.core.Trader;

public class BinanceCandleHandler implements CandleHandler<Candle> {
    private final Strategy<Candle> strategy;
    private final Trader<Candle> trader;

    public BinanceCandleHandler(Strategy<Candle> strategy, Trader<Candle> trader) {
        this.strategy = strategy;
        this.trader = trader;
    }

    @Override
    public void handleCandle(Candle candle) throws Exception {
        strategy.getDecision(candle).ifPresent(decision -> {
            switch (decision) {
                case BUY -> trader.adviceToBuy(candle);
                case SELL -> trader.adviceToSell(candle);
            }
        });
    }
}
