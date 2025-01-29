package autotrader.binance.provider;

import autotrader.binance.model.Balance;

public interface BalanceProvider {
    Balance getBalance(String currency) throws Exception;
}
