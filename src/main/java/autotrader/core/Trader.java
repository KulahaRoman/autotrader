package autotrader.core;

public interface Trader<C> {
    void handleBuySignal(C candle);

    void handleSellSignal(C candle);
}