package autotrader.source;

import autotrader.binance.model.Candle;
import autotrader.core.CandleSource;

import java.util.Iterator;
import java.util.List;

public class FetchedCandleSource implements CandleSource<Candle> {
    private final Iterator<Candle> iterator;

    public FetchedCandleSource(List<Candle> candles) {
        this.iterator = candles.iterator();
    }

    @Override
    public Candle nextCandle() {
        return iterator.next();
    }
}
