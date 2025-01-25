package autotrader.binance.strategy;

import autotrader.binance.HistoryProvider;
import autotrader.binance.adapter.CandleBar;
import autotrader.binance.model.Candle;
import autotrader.core.Decision;
import autotrader.core.Strategy;
import org.ta4j.core.Bar;
import org.ta4j.core.BaseBarSeries;
import org.ta4j.core.BaseStrategy;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.rules.IsFallingRule;
import org.ta4j.core.rules.IsRisingRule;

import java.util.Optional;

public class RiseFallStrategy implements Strategy<Candle> {
    private static final int BAR_SERIES_LENGTH = 500;
    private final BaseBarSeries barSeries;
    private final BaseStrategy strategy;

    public RiseFallStrategy(HistoryProvider historyProvider) throws Exception {
        var history = historyProvider.getCandleHistory(BAR_SERIES_LENGTH);
        var bars = history.stream()
                .map(candle -> (Bar) new CandleBar(candle))
                .limit(history.size() - 1)
                .toList();

        this.barSeries = new BaseBarSeries(bars);
        this.barSeries.setMaximumBarCount(BAR_SERIES_LENGTH);

        var closePrice = new ClosePriceIndicator(barSeries);
        var smoothed = new SMAIndicator(closePrice, 2);

        var entryRule = new IsRisingRule(smoothed, 2);
        var exitRule = new IsFallingRule(smoothed, 2);

        this.strategy = new BaseStrategy(entryRule, exitRule);
    }

    @Override
    public Optional<Decision> getDecision(Candle candle) {
        var bar = new CandleBar(candle);
        barSeries.addBar(bar);

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
