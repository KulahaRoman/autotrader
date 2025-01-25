package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PriceFilter extends Filter {
    private double minPrice;
    private double maxPrice;
    private double tickSize;

    public PriceFilter(double minPrice, double maxPrice, double tickSize) {
        super(FilterType.PRICE_FILTER);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tickSize = tickSize;
    }
}
