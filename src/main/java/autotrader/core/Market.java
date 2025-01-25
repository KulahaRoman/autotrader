package autotrader.core;

public interface Market<T> {
    void placeOrder(T trade) throws Exception;
}
