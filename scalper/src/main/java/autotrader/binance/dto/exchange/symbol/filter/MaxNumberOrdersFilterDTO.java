package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberOrdersFilterDTO extends FilterDTO {
    private int maxNumberOrders;

    public MaxNumberOrdersFilterDTO() {
        super("MAX_NUM_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberOrdersFilterDTO(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super("MAX_NUM_ORDERS");
        this.maxNumberOrders = maxNumberOrders;
    }
}
