package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PercentPriceFilterDTO extends FilterDTO {
    private final double multiplierUp;
    private final double multiplierDown;
    private final int averagePriceMinimums;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PercentPriceFilterDTO(@JsonProperty("multiplierUp") double multiplierUp,
                                 @JsonProperty("multiplierDown") double multiplierDown,
                                 @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super("PERCENT_PRICE");
        this.multiplierUp = multiplierUp;
        this.multiplierDown = multiplierDown;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
