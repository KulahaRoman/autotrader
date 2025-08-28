package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxNumberAlgoOrdersFilterDTO extends FilterDTO {
    private double maxNumberAlgoOrders;

    public MaxNumberAlgoOrdersFilterDTO() {
        super("MAX_NUM_ALGO_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberAlgoOrdersFilterDTO(@JsonProperty("maxNumAlgoOrders") double maxNumberAlgoOrders) {
        super("MAX_NUM_ALGO_ORDERS");
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
