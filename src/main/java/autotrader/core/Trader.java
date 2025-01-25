package autotrader.core;

public interface Trader<C> {
    void adviceToBuy(C candle);

    void adviceToSell(C candle);
}