package autotrader.binance.provider;

public interface ExchangeProvider<E> {
    E getExchange() throws Exception;
}
