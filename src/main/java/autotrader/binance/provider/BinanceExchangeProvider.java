package autotrader.binance.provider;

import autotrader.binance.dto.exchange.ExchangeDTO;
import autotrader.binance.mapper.ExchangeMapper;
import autotrader.binance.model.exchange.Exchange;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collections;

public class BinanceExchangeProvider implements ExchangeProvider {
    private final SpotClient spotClient;

    public BinanceExchangeProvider(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public Exchange getExchange() {
        var response = spotClient.createMarket().exchangeInfo(Collections.emptyMap());
        try {
            var exchangeDTO = JSON.readObject(response, ExchangeDTO.class);
            var exchange = ExchangeMapper.toModel(exchangeDTO);

            return exchange;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
