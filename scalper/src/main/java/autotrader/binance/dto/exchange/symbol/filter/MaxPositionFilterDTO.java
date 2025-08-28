package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxPositionFilterDTO extends FilterDTO {
    private double maxPosition;

    public MaxPositionFilterDTO() {
        super("MAX_POSITION");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MaxPositionFilterDTO(@JsonProperty("maxPosition") double maxPosition) {
        super("MAX_POSITION");
        this.maxPosition = maxPosition;
    }
}
