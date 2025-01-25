package autotrader.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class BaseUpdatableScalper<C, U> extends BaseScalper<C> {
    protected final UpdateSource<U> updateSource;
    protected final UpdateHandler<U> updateHandler;

    public BaseUpdatableScalper(CandleSource<C> candleSource, CandleHandler<C> candleHandler,
                                UpdateSource<U> updateSource, UpdateHandler<U> updateHandler) {
        super(candleSource, candleHandler);
        this.updateSource = updateSource;
        this.updateHandler = updateHandler;
    }

    @Override
    public void run() throws Exception {
        running.set(true);

        try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
            var candles = CompletableFuture.runAsync(() -> {
                try {
                    while (running.get()) {
                        var candle = candleSource.nextCandle();
                        candleHandler.handleCandle(candle);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executor);
            var updates = CompletableFuture.runAsync(() -> {
                try {
                    while (running.get()) {
                        var update = updateSource.nextUpdate();
                        updateHandler.handleUpdate(update);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executor);

            CompletableFuture.allOf(candles, updates).join();
        }
    }

    @Override
    public void close() throws Exception {
        candleSource.close();
        updateSource.close();
    }
}
