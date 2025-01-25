package autotrader.binance;

import java.util.Properties;

public interface TraderStateProvider {
    TraderState getTraderState(Properties properties) throws Exception;
}
