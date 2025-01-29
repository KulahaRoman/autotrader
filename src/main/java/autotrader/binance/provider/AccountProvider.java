package autotrader.binance.provider;

import autotrader.binance.model.account.Account;

public interface AccountProvider {
    Account getAccount() throws Exception;
}
