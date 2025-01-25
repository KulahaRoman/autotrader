package autotrader.binance.model.exchange.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeMaxNumberOrdersFilter extends Filter {
    private int maxNumberOrders;

    public ExchangeMaxNumberOrdersFilter(int maxNumberOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ORDERS);
        this.maxNumberOrders = maxNumberOrders;
    }
}
