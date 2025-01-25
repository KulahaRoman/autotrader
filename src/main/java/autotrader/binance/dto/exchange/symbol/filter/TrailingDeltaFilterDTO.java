package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TrailingDeltaFilterDTO extends FilterDTO {
    private final double minTrailingAboveDelta;
    private final double maxTrailingAboveDelta;
    private final double minTrailingBelowDelta;
    private final double maxTrailingBelowDelta;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TrailingDeltaFilterDTO(@JsonProperty("minTrailingAboveDelta") double minTrailingAboveDelta,
                                  @JsonProperty("maxTrailingAboveDelta") double maxTrailingAboveDelta,
                                  @JsonProperty("minTrailingBelowDelta") double minTrailingBelowDelta,
                                  @JsonProperty("maxTrailingBelowDelta") double maxTrailingBelowDelta) {
        super("TRAILING_DELTA");
        this.minTrailingAboveDelta = minTrailingAboveDelta;
        this.maxTrailingAboveDelta = maxTrailingAboveDelta;
        this.minTrailingBelowDelta = minTrailingBelowDelta;
        this.maxTrailingBelowDelta = maxTrailingBelowDelta;
    }
}
