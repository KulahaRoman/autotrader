package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MinimalNotionalFilterDTO extends FilterDTO {
    private final double minNotional;
    private final boolean applyToMarket;
    private final int averagePriceMinimums;

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
