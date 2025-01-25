package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxNumberAlgoOrdersFilterDTO extends FilterDTO {
    private final double maxNumberAlgoOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxNumberAlgoOrdersFilterDTO(@JsonProperty("maxNumAlgoOrders") double maxNumberAlgoOrders) {
        super("MAX_NUM_ALGO_ORDERS");
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
