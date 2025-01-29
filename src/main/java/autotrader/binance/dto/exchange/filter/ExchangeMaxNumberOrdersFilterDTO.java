package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeMaxNumberOrdersFilterDTO extends FilterDTO {
    private int maxNumberOrders;

    public ExchangeMaxNumberOrdersFilterDTO() {
        super("EXCHANGE_MAX_NUM_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberOrdersFilterDTO(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super("EXCHANGE_MAX_NUM_ORDERS");
        this.maxNumberOrders = maxNumberOrders;
    }
}
