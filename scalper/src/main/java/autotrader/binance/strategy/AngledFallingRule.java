package autotrader.binance.strategy;

import org.ta4j.core.Indicator;
import org.ta4j.core.TradingRecord;
import org.ta4j.core.num.Num;
import org.ta4j.core.rules.AbstractRule;

public class AngledFallingRule extends AbstractRule {
    private final Indicator<Num> ref;
    private final int barCount;
    private final double angle;

    public AngledFallingRule(Indicator<Num> ref, int barCount, double angle) {
        this.ref = ref;
        this.barCount = barCount;
        this.angle = angle;
    }

    @Override
    public boolean isSatisfied(int index, TradingRecord tradingRecord) {
        var diff = ref.getValue(index).minus(ref.getValue(Math.max(0, index - barCount)));
        var rad = Math.atan(diff.doubleValue());
        var deg = rad * 180.0 / Math.PI;

        if (deg <= -angle) {
            traceIsSatisfied(index, true);
            return true;
        }

        return false;
    }
}
