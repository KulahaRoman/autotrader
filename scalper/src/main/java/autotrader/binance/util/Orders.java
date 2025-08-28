package autotrader.binance.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Orders {
    public static Map<String, Object> createBuy(String symbol, double amount) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "BUY");
        order.put("type", "MARKET");
        order.put("quantity", amount);

        return order;
    }

    public static Map<String, Object> createStopLoss(String symbol, double amount, double stopPrice) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "SELL");
        order.put("type", "STOP_LOSS");
        order.put("quantity", amount);
        order.put("stopPrice", stopPrice);

        return order;
    }

    public static Map<String, Object> createTrailingStop(String symbol, double amount, int delta) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "SELL");
        order.put("type", "STOP_LOSS");
        order.put("quantity", amount);
        order.put("trailingDelta", delta);

        return order;
    }

    public static Map<String, Object> createSell(String symbol, double amount) {
        Map<String, Object> order = new LinkedHashMap<>();
        order.put("symbol", symbol);
        order.put("side", "SELL");
        order.put("type", "MARKET");
        order.put("quantity", amount);

        return order;
    }
}
