package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotionalFilterDTO extends FilterDTO {
    private double minNotional;
    private boolean applyMinToMarket;
    private double maxNotional;
    private boolean applyMaxToMarket;
    private int averagePriceMinimums;

    public NotionalFilterDTO() {
        super("NOTIONAL");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NotionalFilterDTO(@JsonProperty("minNotional") double minNotional,
                             @JsonProperty("applyMinToMarket") boolean applyMinToMarket,
                             @JsonProperty("maxNotional") double maxNotional,
                             @JsonProperty("applyMaxToMarket") boolean applyMaxToMarket,
                             @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super("NOTIONAL");
        this.minNotional = minNotional;
        this.applyMinToMarket = applyMinToMarket;
        this.maxNotional = maxNotional;
        this.applyMaxToMarket = applyMaxToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
