package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinimalNotionalFilterDTO extends FilterDTO {
    private double minNotional;
    private boolean applyToMarket;
    private int averagePriceMinimums;

    public MinimalNotionalFilterDTO() {
        super("MIN_NOTIONAL");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MinimalNotionalFilterDTO(@JsonProperty("minNotional") double minNotional,
                                    @JsonProperty("applyToMarket") boolean applyToMarket,
                                    @JsonProperty("avgPriceMins") int averagePriceMinimums) {
        super("MIN_NOTIONAL");
        this.minNotional = minNotional;
        this.applyToMarket = applyToMarket;
        this.averagePriceMinimums = averagePriceMinimums;
    }
}
