package autotrader.binance.model.exchange.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeMaxNumberAlgoOrdersFilter extends Filter {
    private int maxNumberAlgoOrders;

    public ExchangeMaxNumberAlgoOrdersFilter(int maxNumberAlgoOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ALGO_ORDERS);
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
