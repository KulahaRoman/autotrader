package autotrader.binance.provider;

import autotrader.binance.ScalperState;

import java.util.Properties;

public interface ScalperStateProvider {
    ScalperState getScalperState(Properties properties) throws Exception;
}
