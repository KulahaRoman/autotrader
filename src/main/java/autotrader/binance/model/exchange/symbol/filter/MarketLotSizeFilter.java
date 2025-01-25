package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketLotSizeFilter extends Filter {
    private double minQuantity;
    private double maxQuantity;
    private double stepSize;

    public MarketLotSizeFilter(double minQuantity, double maxQuantity, double stepSize) {
        super(FilterType.MARKET_LOT_SIZE);
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.stepSize = stepSize;
    }
}
