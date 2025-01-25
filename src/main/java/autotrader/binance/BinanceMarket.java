package autotrader.binance;

import autotrader.binance.dto.OrderDTO;
import autotrader.core.Market;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.LinkedHashMap;
import java.util.Map;

public class BinanceMarket implements Market<Trade> {
    private final SpotClient client;

    public BinanceMarket(SpotClient client) {
        this.client = client;
    }

    @Override
    public void placeOrder(Trade trade) {
        switch (trade.getType()) {
            case BUY -> placeBuyOrder(trade);
            case SELL -> placeSellOrder(trade);
        }
    }

    private void placeBuyOrder(Trade trade) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", trade.getSymbol());
        parameters.put("side", "BUY");
        parameters.put("type", "STOP_LOSS");
        parameters.put("quantity", trade.getAmount());
        parameters.put("stopPrice", trade.getPrice());

        var response = client.createTrade().testNewOrder(parameters);
        try {
            JSON.readObject(response, OrderDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse response.", e);
        }
    }

    private void placeSellOrder(Trade trade) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", trade.getSymbol());
        parameters.put("side", "SELL");
        parameters.put("type", "MARKET");
        parameters.put("quantity", trade.getAmount());

        client.createTrade().testNewOrder(parameters);
    }
}
