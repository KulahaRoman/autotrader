package autotrader.binance.strategy;

import autotrader.binance.bar.CandleBar;
import autotrader.binance.model.Candle;
import autotrader.binance.provider.HistoryProvider;
import autotrader.core.Decision;
import autotrader.core.Strategy;
import org.ta4j.core.Bar;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.BaseStrategy;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;

import java.util.Optional;

public class RiseFallStrategy implements Strategy<Candle> {
    private static final int BAR_SERIES_LENGTH = 500;

    private final BaseBarSeries barSeries;
    private final BaseStrategy strategy;

    public RiseFallStrategy(HistoryProvider historyProvider) throws Exception {
        var history = historyProvider.getCandleHistory(BAR_SERIES_LENGTH);
        var bars = history.stream()
                .map(candle -> (Bar) new CandleBar(candle))
                .limit(history.size()).toList();

        this.barSeries = new BaseBarSeries(bars);
        this.barSeries.setMaximumBarCount(BAR_SERIES_LENGTH);

        var closePrice = new ClosePriceIndicator(barSeries);

        var trend = new SMAIndicator(closePrice, 10);

        var entryRule = new AngledRisingRule(trend, 2, 30);
        var exitRule = new AngledFallingRule(trend, 2, 15);

        this.strategy = new BaseStrategy(entryRule, exitRule);
    }

    @Override
    public Optional<Decision> getDecision(Candle candle) {
        var nextBar = new CandleBar(candle);
        var prevBar = barSeries.getLastBar();
        if (nextBar.getEndTime().isAfter(prevBar.getEndTime())) {
            barSeries.addBar(nextBar);
        }

        var index = barSeries.getEndIndex();
        if (strategy.shouldEnter(index)) {
            return Optional.of(Decision.BUY);
        } else if (strategy.shouldExit(index)) {
            return Optional.of(Decision.SELL);
        } else {
            return Optional.empty();
        }
    }
}
