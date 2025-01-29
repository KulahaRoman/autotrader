package autotrader.binance.provider;

import autotrader.binance.TraderState;

import java.util.Properties;

public interface TraderStateProvider {
    TraderState getTraderState(Properties properties) throws Exception;
}
