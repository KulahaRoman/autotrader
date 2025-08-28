package autotrader.binance;

import autotrader.binance.dto.OrderDTO;
import autotrader.binance.mapper.OrderMapper;
import autotrader.binance.model.Order;
import autotrader.binance.model.OrderStatus;
import autotrader.core.Market;
import autotrader.util.JSON;
import com.binance.connector.client.SpotClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinanceMarket implements Market<Order> {
    private final SpotClient spotClient;

    public BinanceMarket(SpotClient spotClient) {
        this.spotClient = spotClient;
    }

    @Override
    public Order placeOrder(Map<String, Object> params) {
        var response = spotClient.createTrade().newOrder(params);
        try {
            var orderDTO = JSON.readObject(response, OrderDTO.class);
            return OrderMapper.toModel(orderDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse response.", e);
        }
    }

    @Override
    public void cancelOrder(Order order) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", order.getSymbol());
        parameters.put("orderId", order.getOrderID());
        parameters.put("timestamp", Instant.now().toEpochMilli());

        var response = spotClient.createTrade().cancelOrder(parameters);
        try {
            var orderDTO = JSON.readObject(response, OrderDTO.class);
            if (OrderMapper.toModel(orderDTO).getStatus() != OrderStatus.CANCELED) {
                throw new RuntimeException("Failed to cancel order.");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse response.", e);
        }
    }
}