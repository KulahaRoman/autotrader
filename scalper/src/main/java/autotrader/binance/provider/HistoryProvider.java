package autotrader.binance.provider;

import java.util.List;

public interface HistoryProvider<C> {
    List<C> getCandleHistory(long size) throws Exception;

    List<C> getCandleHistory(long size, long from, long to) throws Exception;
}
