package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IcebergPartsFilter extends Filter {
    private int limit;

    public IcebergPartsFilter() {
        super(FilterType.ICEBERG_PARTS);
    }

    public IcebergPartsFilter(int limit) {
        super(FilterType.ICEBERG_PARTS);
        this.limit = limit;
    }
}
