package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxPositionFilter extends Filter {
    private double maxPosition;

    public MaxPositionFilter() {
        super(FilterType.MAX_POSITION);
    }

    public MaxPositionFilter(double maxPosition) {
        super(FilterType.MAX_POSITION);
        this.maxPosition = maxPosition;
    }
}
