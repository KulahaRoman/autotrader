package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentPriceBySideFilter extends Filter {
    private double bidMultiplierUp;
    private double bidMultiplierDown;
    private double askMultiplierUp;
    private double askMultiplierDown;
    private int averagePriceMinimums;

    public PercentPriceBySideFilter() {
        super(FilterType.PERCENT_PRICE_BY_SIDE);
    }

    public PercentPriceBySideFilter(double bidMultiplierUp, double bidMultiplierDown,
                                    double askMultiplierUp, double askMultiplierDown,
                                    int averagePriceMinimums) {
        super(FilterType.PERCENT_PRICE_BY_SIDE);
        this.bidMultiplierUp = bidMultiplierUp;
        this.bidMultiplierDown = bidMultiplierDown;
        this.askMultiplierUp = askMultiplierUp;
        this.askMultiplierDown = askMultiplierDown;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
