package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LotSizeFilterDTO extends FilterDTO {
    private double minQuantity;
    private double maxQuantity;
    private double stepSize;

    public LotSizeFilterDTO() {
        super("LOT_SIZE");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LotSizeFilterDTO(@JsonProperty("minQty") double minQuantity,
                            @JsonProperty("maxQty") double maxQuantity,
                            @JsonProperty("stepSize") double stepSize) {
        super("LOT_SIZE");
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.stepSize = stepSize;
    }
}
