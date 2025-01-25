package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberIcebergOrdersFilterDTO extends FilterDTO {
    private final int maxNumberIcebergOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberIcebergOrdersFilterDTO(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super("MAX_NUM_ICEBERG_ORDERS");
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
