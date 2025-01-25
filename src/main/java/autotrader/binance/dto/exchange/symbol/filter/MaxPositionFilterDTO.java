package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MaxPositionFilterDTO extends FilterDTO {
    private final double maxPosition;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxPositionFilterDTO(@JsonProperty("maxPosition") double maxPosition) {
        super("MAX_POSITION");
        this.maxPosition = maxPosition;
    }
}
