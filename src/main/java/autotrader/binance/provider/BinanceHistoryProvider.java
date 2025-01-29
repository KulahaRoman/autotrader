package autotrader.binance.provider;

import autotrader.binance.adapter.CandleBar;
import autotrader.binance.model.Candle;
import autotrader.binance.util.Periods;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

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
                    .map(values ->
                            new CandleBar(Periods.toDuration(period),
                                    ZonedDateTime.ofInstant(Instant.ofEpochMilli((long) values.get(6)),
                                            ZoneId.of("UTC")),
                                    Double.parseDouble((String) values.get(1)),
                                    Double.parseDouble((String) values.get(2)),
                                    Double.parseDouble((String) values.get(3)),
                                    Double.parseDouble((String) values.get(4)),
                                    Double.parseDouble((String) values.get(5))).toCandle())
                    .toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
