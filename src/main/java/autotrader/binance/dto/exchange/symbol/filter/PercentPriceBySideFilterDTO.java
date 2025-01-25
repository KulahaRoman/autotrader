package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PercentPriceBySideFilterDTO extends FilterDTO {
    private final double bidMultiplierUp;
    private final double bidMultiplierDown;
    private final double askMultiplierUp;
    private final double askMultiplierDown;
    private final int averagePriceMinimums;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PercentPriceBySideFilterDTO(@JsonProperty("bidMultiplierUp") double bidMultiplierUp,
                                       @JsonProperty("bidMultiplierDown") double bidMultiplierDown,
                                       @JsonProperty("askMultiplierUp") double askMultiplierUp,
                                       @JsonProperty("askMultiplierDown") double askMultiplierDown,
                                       @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super("PERCENT_PRICE_BY_SIDE");
        this.bidMultiplierUp = bidMultiplierUp;
        this.bidMultiplierDown = bidMultiplierDown;
        this.askMultiplierUp = askMultiplierUp;
        this.askMultiplierDown = askMultiplierDown;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
