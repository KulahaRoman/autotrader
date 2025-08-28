package autotrader.binance.dto.candle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandleStickEventDTO {
    @JsonProperty("e")
    private String eventType;
    @JsonProperty("E")
    private long eventTime;
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("k")
    private CandleStickDTO candleStickDTO;
}
