package autotrader.binance.model;

import java.time.Duration;
import java.time.ZonedDateTime;

public interface Candle {
    Duration getTimePeriod();

    ZonedDateTime getOpenTime();

    ZonedDateTime getCloseTime();

    double getOpenPrice();

    double getHighPrice();

    double getLowPrice();

    double getClosePrice();

    double getVolume();

    double getAmount();

    long getTrades();

    boolean isBearish();

    boolean isBullish();

    boolean isClosed();
}
