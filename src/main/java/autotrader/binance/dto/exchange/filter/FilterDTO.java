package autotrader.binance.dto.exchange.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "filterType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExchangeMaxNumberAlgoOrdersFilterDTO.class, name = "EXCHANGE_MAX_NUM_ALGO_ORDERS"),
        @JsonSubTypes.Type(value = ExchangeMaxNumberIcebergOrdersFilterDTO.class, name = "EXCHANGE_MAX_NUM_ICEBERG_ORDERS"),
        @JsonSubTypes.Type(value = ExchangeMaxNumberOrdersFilterDTO.class, name = "EXCHANGE_MAX_NUM_ORDERS")
})
public abstract class FilterDTO {
    @JsonProperty("filterType")
    private String filterType;
}
