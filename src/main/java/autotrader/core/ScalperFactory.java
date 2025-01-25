package autotrader.core;

import java.util.Properties;

public interface ScalperFactory {
    Scalper createScalper(Properties properties) throws Exception;
}
