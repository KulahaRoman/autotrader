package autotrader.binance;

import autotrader.binance.model.Candle;
import autotrader.core.Market;
import autotrader.core.Trader;

public class BinanceTrader implements Trader<Candle> {
    private final Market<Trade> market;
    
    private final TraderState traderState;

    public BinanceTrader(Market<Trade> market, TraderState traderState) {
        this.market = market;
        this.traderState = traderState;
    }

    @Override
    public void adviceToBuy(Candle candle) {

    }

    @Override
    public void adviceToSell(Candle candle) {

    }
}
