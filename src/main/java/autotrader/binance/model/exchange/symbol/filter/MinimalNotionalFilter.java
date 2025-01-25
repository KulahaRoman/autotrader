package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinimalNotionalFilter extends Filter {
    private double minNotional;
    private boolean applyToMarket;
    private int averagePriceMinimums;

    public MinimalNotionalFilter(double minNotional, boolean applyToMarket, int averagePriceMinimums) {
        super(FilterType.MIN_NOTIONAL);
        this.minNotional = minNotional;
        this.applyToMarket = applyToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
