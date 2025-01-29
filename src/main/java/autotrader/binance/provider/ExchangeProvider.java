package autotrader.binance.provider;

import autotrader.binance.model.exchange.Exchange;

public interface ExchangeProvider {
    Exchange getExchange() throws Exception;
}
