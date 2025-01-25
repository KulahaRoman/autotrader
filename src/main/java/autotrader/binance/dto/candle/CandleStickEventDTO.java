package autotrader.binance.dto.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CandleStickEventDTO {
    @JsonProperty("e")
    private final String eventType;
    @JsonProperty("E")
    private final long eventTime;
    @JsonProperty("s")
    private final String symbol;
    @JsonProperty("k")
    private final CandleStickDTO candleStickDTO;
}
