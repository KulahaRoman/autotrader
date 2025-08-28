package autotrader.binance.bar;

import autotrader.binance.model.Candle;
import lombok.*;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

import java.time.Duration;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandleBar implements CloseableBar {
    private Duration timePeriod;
    private ZonedDateTime beginTime;
    private ZonedDateTime endTime;
    private Num openPrice;
    private Num highPrice;
    private Num lowPrice;
    private Num closePrice;
    private Num volume;
    private Num amount;
    private long trades;
    private boolean isClosed;

    public CandleBar(Candle candle) {
        this.timePeriod = candle.getTimePeriod();
        this.beginTime = candle.getOpenTime();
        this.endTime = candle.getCloseTime();
        this.openPrice = DecimalNum.valueOf(candle.getOpenPrice());
        this.highPrice = DecimalNum.valueOf(candle.getHighPrice());
        this.lowPrice = DecimalNum.valueOf(candle.getLowPrice());
        this.closePrice = DecimalNum.valueOf(candle.getClosePrice());
        this.volume = DecimalNum.valueOf(candle.getVolume());
        this.amount = DecimalNum.valueOf(candle.getAmount());
        this.trades = candle.getTrades();
        this.isClosed = candle.isClosed();
    }

    @Override
    public void addTrade(Num tradeVolume, Num tradePrice) {
        addPrice(tradePrice);

        volume = volume.plus(tradeVolume);
        amount = amount.plus(tradeVolume.multipliedBy(tradePrice));
        trades++;
    }

    @Override
    public void addPrice(Num price) {
        if (openPrice == null) {
            openPrice = price;
        }
        closePrice = price;
        if (highPrice == null || highPrice.isLessThan(price)) {
            highPrice = price;
        }
        if (lowPrice == null || lowPrice.isGreaterThan(price)) {
            lowPrice = price;
        }
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
                return self.isClosed();
            }
        };
    }
}
