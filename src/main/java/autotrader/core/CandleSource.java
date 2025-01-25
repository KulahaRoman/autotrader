package autotrader.core;

public interface CandleSource<C> extends AutoCloseable {
    C nextCandle() throws Exception;
}
