package autotrader.core;

import java.util.Map;

public interface Market<O> {
    O placeOrder(Map<String, Object> params);

    void cancelOrder(O order);
}
