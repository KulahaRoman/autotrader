package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberAlgoOrdersFilterDTO extends FilterDTO {
    private final int maxNumberAlgoOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberAlgoOrdersFilterDTO(@JsonProperty("maxNumAlgoOrders") int maxNumberAlgoOrders) {
        super("EXCHANGE_MAX_NUM_ALGO_ORDERS");
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
