package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberIcebergOrdersFilterDTO extends FilterDTO {
    private final int maxNumberIcebergOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberIcebergOrdersFilterDTO(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super("EXCHANGE_MAX_NUM_ICEBERG_ORDERS");
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
