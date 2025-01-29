package autotrader.binance.provider;

import autotrader.binance.bar.CandleBar;
import autotrader.binance.model.Candle;
import autotrader.binance.util.Periods;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.ta4j.core.num.DecimalNum;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BinanceHistoryProvider implements HistoryProvider {
    private final SpotClient client;
    private final Properties configuration;

    public BinanceHistoryProvider(SpotClient client, Properties configuration) {
        this.client = client;
        this.configuration = configuration;
    }

    @Override
    public List<Candle> getCandleHistory(long size) {
        var symbol = configuration.getProperty("symbol").toUpperCase();
        var period = configuration.getProperty("period");

        var parameters = new HashMap<String, Object>();
        parameters.put("symbol", symbol);
        parameters.put("interval", period);

        var response = client.createMarket().klines(parameters);
        try {
            var responseJson = JSON.readObject(response, new TypeReference<ArrayList<ArrayList<Object>>>() {
            });
            return responseJson
                    .stream()
                    .map(values -> {
                        var bar = new CandleBar();
                        bar.setTimePeriod(Periods.toDuration(period));
                        bar.setBeginTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli((long) values.get(0)),
                                ZoneId.of("UTC")));
                        bar.setEndTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli((long) values.get(6)),
                                ZoneId.of("UTC")));
                        bar.setOpenPrice(DecimalNum.valueOf((String) values.get(1)));
                        bar.setHighPrice(DecimalNum.valueOf((String) values.get(2)));
                        bar.setLowPrice(DecimalNum.valueOf((String) values.get(3)));
                        bar.setClosePrice(DecimalNum.valueOf((String) values.get(4)));
                        bar.setVolume(DecimalNum.valueOf((String) values.get(5)));
                        bar.setTrades((long) values.get(8));
                        bar.setClosed(true);

                        return bar.toCandle();
                    }).toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
