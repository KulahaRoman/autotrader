package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberIcebergOrdersFilter extends Filter {
    private int maxNumberIcebergOrders;

    public MaxNumberIcebergOrdersFilter(int maxNumberIcebergOrders) {
        super(FilterType.MAX_NUM_ICEBERG_ORDERS);
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
