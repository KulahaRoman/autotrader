package autotrader.binance;

import autotrader.binance.model.Candle;

import java.util.List;

public interface HistoryProvider {
    List<Candle> getCandleHistory(long size) throws Exception;
}
