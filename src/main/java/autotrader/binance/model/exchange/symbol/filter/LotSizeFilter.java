package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotSizeFilter extends Filter {
    private double minQuantity;
    private double maxQuantity;
    private double stepSize;

    public LotSizeFilter(double minQuantity, double maxQuantity, double stepSize) {
        super(FilterType.LOT_SIZE);
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.stepSize = stepSize;
    }
}
