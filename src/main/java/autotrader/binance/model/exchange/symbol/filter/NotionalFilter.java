package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotionalFilter extends Filter {
    private double minNotional;
    private boolean applyMinToMarket;
    private double maxNotional;
    private boolean applyMaxToMarket;
    private int averagePriceMinimums;

    public NotionalFilter(double minNotional, boolean applyMinToMarket, double maxNotional,
                          boolean applyMaxToMarket, int averagePriceMinimums) {
        super(FilterType.NOTIONAL);
        this.minNotional = minNotional;
        this.applyMinToMarket = applyMinToMarket;
        this.maxNotional = maxNotional;
        this.applyMaxToMarket = applyMaxToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
