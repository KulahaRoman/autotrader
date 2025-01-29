package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberOrdersFilter extends Filter {
    private int maxNumberOrders;

    public MaxNumberOrdersFilter() {
        super(FilterType.MAX_NUM_ORDERS);
    }

    public MaxNumberOrdersFilter(int maxNumberOrders) {
        super(FilterType.MAX_NUM_ORDERS);
        this.maxNumberOrders = maxNumberOrders;
    }
}
