package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeMaxNumberAlgoOrdersFilterDTO extends FilterDTO {
    private int maxNumberAlgoOrders;

    public ExchangeMaxNumberAlgoOrdersFilterDTO() {
        super("EXCHANGE_MAX_NUM_ALGO_ORDERS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ExchangeMaxNumberAlgoOrdersFilterDTO(@JsonProperty("maxNumAlgoOrders") int maxNumberAlgoOrders) {
        super("EXCHANGE_MAX_NUM_ALGO_ORDERS");
        this.maxNumberAlgoOrders = maxNumberAlgoOrders;
    }
}
