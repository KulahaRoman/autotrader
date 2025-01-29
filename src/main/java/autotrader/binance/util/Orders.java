package autotrader.binance.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Orders {
    public static Map<String, Object> createBuyOrder(String symbol, double amount) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "BUY");
        order.put("type", "MARKET");
        order.put("quantity", amount);

        return order;
    }

    public static Map<String, Object> createStopLossOrder(String symbol, double amount, double stopPrice) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "SELL");
        order.put("type", "STOP_LOSS");
        order.put("quantity", amount);
        order.put("stopPrice", stopPrice);

        return order;
    }

    public static Map<String, Object> createSellOrder(String symbol, double amount) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "SELL");
        order.put("type", "MARKET");
        order.put("quantity", amount);

        return order;
    }
}
