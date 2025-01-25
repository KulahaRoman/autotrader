package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MarketLotSizeFilterDTO extends FilterDTO {
    private final double minQuantity;
    private final double maxQuantity;
    private final double stepSize;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MarketLotSizeFilterDTO(@JsonProperty("minQty") double minQuantity,
                                  @JsonProperty("maxQty") double maxQuantity,
                                  @JsonProperty("stepSize") double stepSize) {
        super("MARKET_LOT_SIZE");
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.stepSize = stepSize;
    }
}
