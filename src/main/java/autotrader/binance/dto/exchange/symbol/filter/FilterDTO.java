package autotrader.binance.dto.exchange.symbol.filter;

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
        @JsonSubTypes.Type(value = IcebergPartsFilterDTO.class, name = "ICEBERG_PARTS"),
        @JsonSubTypes.Type(value = LotSizeFilterDTO.class, name = "LOT_SIZE"),
        @JsonSubTypes.Type(value = MarketLotSizeFilterDTO.class, name = "MARKET_LOT_SIZE"),
        @JsonSubTypes.Type(value = MaxNumberAlgoOrdersFilterDTO.class, name = "MAX_NUM_ALGO_ORDERS"),
        @JsonSubTypes.Type(value = MaxNumberIcebergOrdersFilterDTO.class, name = "MAX_NUM_ICEBERG_ORDERS"),
        @JsonSubTypes.Type(value = MaxNumberOrdersFilterDTO.class, name = "MAX_NUM_ORDERS"),
        @JsonSubTypes.Type(value = MaxPositionFilterDTO.class, name = "MAX_POSITION"),
        @JsonSubTypes.Type(value = MinimalNotionalFilterDTO.class, name = "MIN_NOTIONAL"),
        @JsonSubTypes.Type(value = NotionalFilterDTO.class, name = "NOTIONAL"),
        @JsonSubTypes.Type(value = PercentPriceBySideFilterDTO.class, name = "PERCENT_PRICE_BY_SIDE"),
        @JsonSubTypes.Type(value = PercentPriceFilterDTO.class, name = "PERCENT_PRICE"),
        @JsonSubTypes.Type(value = PriceFilterDTO.class, name = "PRICE_FILTER"),
        @JsonSubTypes.Type(value = TrailingDeltaFilterDTO.class, name = "TRAILING_DELTA")
})
public abstract class FilterDTO {
    @JsonProperty("filterType")
    private String filterType;
}
