package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class PriceFilterDTO extends FilterDTO {
    private final double minPrice;
    private final double maxPrice;
    private final double tickSize;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PriceFilterDTO(@JsonProperty("minPrice") double minPrice,
                          @JsonProperty("maxPrice") double maxPrice,
                          @JsonProperty("tickSize") double tickSize) {
        super("PRICE_FILTER");
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tickSize = tickSize;
    }
}
