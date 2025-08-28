package autotrader.core;

public interface CandleSource<C> {
    C nextCandle();
}
