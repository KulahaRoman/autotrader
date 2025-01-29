package autotrader.binance.model.exchange.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeMaxNumberIcebergOrdersFilter extends Filter {
    private int maxNumberIcebergOrders;

    public ExchangeMaxNumberIcebergOrdersFilter() {
        super(FilterType.EXCHANGE_MAX_NUM_ICEBERG_ORDERS);
    }

    public ExchangeMaxNumberIcebergOrdersFilter(int maxNumberIcebergOrders) {
        super(FilterType.EXCHANGE_MAX_NUM_ICEBERG_ORDERS);
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
