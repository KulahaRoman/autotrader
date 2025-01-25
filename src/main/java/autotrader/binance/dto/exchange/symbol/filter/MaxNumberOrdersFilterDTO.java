package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberOrdersFilterDTO extends FilterDTO {
    private final int maxNumberOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberOrdersFilterDTO(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super("MAX_NUM_ORDERS");
        this.maxNumberOrders = maxNumberOrders;
    }
}
