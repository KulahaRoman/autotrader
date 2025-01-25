package autotrader.core;

import java.util.concurrent.atomic.AtomicBoolean;

public class BaseScalper<C> implements Scalper {
    protected final AtomicBoolean running = new AtomicBoolean(false);

    protected final CandleSource<C> candleSource;
    protected final CandleHandler<C> candleHandler;

    public BaseScalper(CandleSource<C> candleSource, CandleHandler<C> candleHandler) {
        this.candleSource = candleSource;
        this.candleHandler = candleHandler;
    }

    @Override
    public void run() throws Exception {
        running.set(true);

        while (running.get()) {
            var candle = candleSource.nextCandle();
            candleHandler.handleCandle(candle);
        }
    }

    @Override
    public void stop() throws Exception {
        running.set(false);
    }

    @Override
    public void close() throws Exception {
        candleSource.close();
    }
}
