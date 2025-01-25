package autotrader.binance;

import java.util.Properties;

public interface ScalperStateProvider {
    ScalperState getScalperState(Properties properties) throws Exception;
}
