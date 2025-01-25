package autotrader.core;

public interface CandleHandler<C> {
    void handleCandle(C candle) throws Exception;
}
