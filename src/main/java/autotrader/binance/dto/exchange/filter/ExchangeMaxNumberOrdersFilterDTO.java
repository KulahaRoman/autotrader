package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeMaxNumberOrdersFilterDTO extends FilterDTO {
    private final int maxNumberOrders;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberOrdersFilterDTO(@JsonProperty("maxNumOrders") int maxNumberOrders) {
        super("EXCHANGE_MAX_NUM_ORDERS");
        this.maxNumberOrders = maxNumberOrders;
    }
}
