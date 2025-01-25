package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrailingDeltaFilter extends Filter {
    private double minTrailingAboveDelta;
    private double maxTrailingAboveDelta;
    private double minTrailingBelowDelta;
    private double maxTrailingBelowDelta;

    public TrailingDeltaFilter(double minTrailingAboveDelta, double maxTrailingAboveDelta,
                               double minTrailingBelowDelta, double maxTrailingBelowDelta) {
        super(FilterType.TRAILING_DELTA);
        this.minTrailingAboveDelta = minTrailingAboveDelta;
        this.maxTrailingAboveDelta = maxTrailingAboveDelta;
        this.minTrailingBelowDelta = minTrailingBelowDelta;
        this.maxTrailingBelowDelta = maxTrailingBelowDelta;
    }
}
