package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberIcebergOrdersFilterDTO extends FilterDTO {
    private int maxNumberIcebergOrders;

    public MaxNumberIcebergOrdersFilterDTO() {
        super("MAX_NUM_ICEBERG_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberIcebergOrdersFilterDTO(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super("MAX_NUM_ICEBERG_ORDERS");
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
