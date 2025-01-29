package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentPriceFilter extends Filter {
    private double multiplierUp;
    private double multiplierDown;
    private int averagePriceMinimums;

    public PercentPriceFilter() {
        super(FilterType.PERCENT_PRICE);
    }

    public PercentPriceFilter(double multiplierUp, double multiplierDown, int averagePriceMinimums) {
        super(FilterType.PERCENT_PRICE);
        this.multiplierUp = multiplierUp;
        this.multiplierDown = multiplierDown;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
