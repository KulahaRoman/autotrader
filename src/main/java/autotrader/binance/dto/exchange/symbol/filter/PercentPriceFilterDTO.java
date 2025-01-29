package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentPriceFilterDTO extends FilterDTO {
    private double multiplierUp;
    private double multiplierDown;
    private int averagePriceMinimums;

    public PercentPriceFilterDTO() {
        super("PERCENT_PRICE");
    }

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
