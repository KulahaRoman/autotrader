package autotrader.binance.source;

import autotrader.binance.bar.CandleBar;
import autotrader.binance.dto.candle.CandleStickEventDTO;
import autotrader.binance.model.Candle;
import autotrader.binance.util.Periods;
import autotrader.core.CandleSource;
import autotrader.util.JSON;
import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.utils.websocketcallback.WebSocketMessageCallback;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.ta4j.core.num.DecimalNum;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinanceCandleSource implements CandleSource<Candle> {
    private final BlockingQueue<Candle> candles = new LinkedBlockingQueue<>();

    public BinanceCandleSource(WebSocketStreamClient client, Properties configuration) {
        var symbol = configuration.getProperty("symbol").toUpperCase();
        var period = configuration.getProperty("period");

        WebSocketMessageCallback messageCallback = (data) -> {
            try {
                var candleStickEventDTO = JSON.readObject(data, CandleStickEventDTO.class);
                var candleStickDTO = candleStickEventDTO.getCandleStickDTO();

                var bar = new CandleBar();
                bar.setTimePeriod(Periods.toDuration(period));
                bar.setBeginTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(candleStickDTO.getOpenTime()),
                        ZoneId.of("UTC")));
                bar.setEndTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(candleStickDTO.getCloseTime()),
                        ZoneId.of("UTC")));
                bar.setOpenPrice(DecimalNum.valueOf(candleStickDTO.getOpenPrice()));
                bar.setHighPrice(DecimalNum.valueOf(candleStickDTO.getHighPrice()));
                bar.setLowPrice(DecimalNum.valueOf(candleStickDTO.getLowPrice()));
                bar.setClosePrice(DecimalNum.valueOf(candleStickDTO.getClosePrice()));
                bar.setVolume(DecimalNum.valueOf(candleStickDTO.getVolume()));
                bar.setAmount(DecimalNum.valueOf(0.0));
                bar.setTrades(candleStickDTO.getTrades());
                bar.setClosed(candleStickDTO.isClosed());

                var candle = bar.toCandle();
                if (candle.isClosed()) {
                    candles.put(candle);
                }
            } catch (JsonProcessingException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        client.klineStream(symbol, period, messageCallback);
    }

    @Override
    public Candle nextCandle() {
        try {
            return candles.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
