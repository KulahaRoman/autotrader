package autotrader.binance;

import autotrader.binance.adapter.CandleBar;
import autotrader.binance.dto.candle.CandleStickEventDTO;
import autotrader.binance.model.Candle;
import autotrader.binance.util.Periods;
import autotrader.core.CandleSource;
import autotrader.util.JSON;
import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.utils.websocketcallback.WebSocketMessageCallback;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class BinanceCandleSource implements CandleSource<Candle> {
    private final WebSocketStreamClient client;

    private final AtomicReference<Candle> temporaryCandle = new AtomicReference<>();

    public BinanceCandleSource(WebSocketStreamClient client, Properties configuration) {
        this.client = client;

        var symbol = configuration.getProperty("symbol").toUpperCase();
        var period = configuration.getProperty("period");

        WebSocketMessageCallback messageCallback = (data) -> {
            try {
                var candleStickEventDTO = JSON.readObject(data, CandleStickEventDTO.class);
                var candleStickDTO = candleStickEventDTO.getCandleStickDTO();

                temporaryCandle.set(new CandleBar(Periods.toDuration(period),
                        ZonedDateTime.ofInstant(Instant.ofEpochMilli(candleStickDTO.getCloseTime()),
                                ZoneId.of("UTC")),
                        candleStickDTO.getOpenPrice(), candleStickDTO.getHighPrice(),
                        candleStickDTO.getLowPrice(), candleStickDTO.getClosePrice(),
                        candleStickDTO.getVolume(), candleStickDTO.getTrades()).toCandle());

                synchronized (this) {
                    notify();
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };

        client.klineStream(symbol, period, messageCallback);
    }

    @Override
    public Candle nextCandle() {
        synchronized (this) {
            try {
                while (temporaryCandle.get() == null) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var candle = temporaryCandle.get();
        temporaryCandle.set(null);

        return candle;
    }

    @Override
    public void close() throws Exception {
        client.closeAllConnections();
    }
}
