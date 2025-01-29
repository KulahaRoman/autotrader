package autotrader.binance.adapter;

import autotrader.binance.model.Candle;
import lombok.Getter;
import lombok.Setter;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.function.Function;

@Getter
@Setter
public class CandleBar extends BaseBar {
    private boolean isClosed;

    public CandleBar(Candle candle) {
        super(candle.getTimePeriod(),
                candle.getCloseTime(),
                DecimalNum.valueOf(candle.getOpenPrice()),
                DecimalNum.valueOf(candle.getHighPrice()),
                DecimalNum.valueOf(candle.getLowPrice()),
                DecimalNum.valueOf(candle.getClosePrice()),
                DecimalNum.valueOf(candle.getVolume()),
                DecimalNum.valueOf(candle.getAmount()),
                candle.getTrades());
        this.isClosed = candle.isClosed();
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime, Function<Number, Num> numFunction) {
        super(timePeriod, endTime, numFunction);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     double openPrice, double highPrice, double lowPrice,
                     double closePrice, double volume) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     double openPrice, double highPrice, double lowPrice,
                     double closePrice, double volume, double amount) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume, amount);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     double openPrice, double highPrice, double lowPrice,
                     double closePrice, double volume, double amount,
                     long trades, Function<Number, Num> numFunction) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice,
                volume, amount, trades, numFunction);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     BigDecimal openPrice, BigDecimal highPrice, BigDecimal lowPrice,
                     BigDecimal closePrice, BigDecimal volume) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     BigDecimal openPrice, BigDecimal highPrice, BigDecimal lowPrice,
                     BigDecimal closePrice, BigDecimal volume, BigDecimal amount) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume, amount);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     BigDecimal openPrice, BigDecimal highPrice, BigDecimal lowPrice,
                     BigDecimal closePrice, BigDecimal volume, BigDecimal amount,
                     long trades, Function<Number, Num> numFunction) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice,
                volume, amount, trades, numFunction);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     String openPrice, String highPrice, String lowPrice,
                     String closePrice, String volume) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     String openPrice, String highPrice, String lowPrice, String closePrice,
                     String volume, String amount) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume, amount);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     String openPrice, String highPrice, String lowPrice, String closePrice,
                     String volume, String amount, String trades, Function<Number, Num> numFunction) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice,
                volume, amount, trades, numFunction);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     Num openPrice, Num highPrice, Num lowPrice, Num closePrice, Num volume, Num amount) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume, amount);
    }

    public CandleBar(Duration timePeriod, ZonedDateTime endTime,
                     Num openPrice, Num highPrice, Num lowPrice, Num closePrice,
                     Num volume, Num amount, long trades) {
        super(timePeriod, endTime, openPrice, highPrice, lowPrice, closePrice, volume, amount, trades);
    }

    public Candle toCandle() {
        var self = this;
        return new Candle() {
            @Override
            public Duration getTimePeriod() {
                return self.getTimePeriod();
            }

            @Override
            public ZonedDateTime getOpenTime() {
                return self.getBeginTime();
            }

            @Override
            public ZonedDateTime getCloseTime() {
                return self.getEndTime();
            }

            @Override
            public double getOpenPrice() {
                return self.getOpenPrice().doubleValue();
            }

            @Override
            public double getHighPrice() {
                return self.getHighPrice().doubleValue();
            }

            @Override
            public double getLowPrice() {
                return self.getLowPrice().doubleValue();
            }

            @Override
            public double getClosePrice() {
                return self.getClosePrice().doubleValue();
            }

            @Override
            public double getVolume() {
                return self.getVolume().doubleValue();
            }

            @Override
            public double getAmount() {
                return self.getAmount().doubleValue();
            }

            @Override
            public long getTrades() {
                return self.getTrades();
            }

            @Override
            public boolean isBearish() {
                return self.isBearish();
            }

            @Override
            public boolean isBullish() {
                return self.isBullish();
            }

            @Override
            public boolean isClosed() {
                return self.isClosed;
            }
        };
    }
}
