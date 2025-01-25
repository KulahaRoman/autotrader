package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberAlgoOrdersFilter extends Filter {
    private double maxNumberAlgoOrders;

    public MaxNumberAlgoOrdersFilter(double maxNumberAlgoOrders) {
        super(FilterType.MAX_NUM_ALGO_ORDERS);
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
