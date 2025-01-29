package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeMaxNumberIcebergOrdersFilterDTO extends FilterDTO {
    private int maxNumberIcebergOrders;

    public ExchangeMaxNumberIcebergOrdersFilterDTO() {
        super("EXCHANGE_MAX_NUM_ICEBERG_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberIcebergOrdersFilterDTO(@JsonProperty("maxNumIcebergOrders") int maxNumberIcebergOrders) {
        super("EXCHANGE_MAX_NUM_ICEBERG_ORDERS");
        this.maxNumberIcebergOrders = maxNumberIcebergOrders;
    }
}
