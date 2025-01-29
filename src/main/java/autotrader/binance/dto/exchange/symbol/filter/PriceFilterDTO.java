package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PriceFilterDTO extends FilterDTO {
    private double minPrice;
    private double maxPrice;
    private double tickSize;

    public PriceFilterDTO() {
        super("PRICE_FILTER");
    }

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
