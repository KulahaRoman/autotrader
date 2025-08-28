package autotrader.binance.provider;

import autotrader.binance.dto.account.AccountDTO;
import autotrader.binance.mapper.AccountMapper;
import autotrader.binance.model.account.Account;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;
import java.util.HashMap;

public class BinanceAccountProvider implements AccountProvider {
    private final SpotClient spotClient;

    public BinanceAccountProvider(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public Account getAccount() {
        var parameters = new HashMap<String, Object>();
        parameters.put("timestamp", Instant.now().toEpochMilli());

        var response = spotClient.createTrade().account(parameters);
        try {
            var accountDTO = JSON.readObject(response, AccountDTO.class);
            return AccountMapper.toModel(accountDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
