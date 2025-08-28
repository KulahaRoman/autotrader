package autotrader.core;

public interface DynamicTrader<C> extends Trader<C> {
    void handleCandleSignal(C candle);
}
