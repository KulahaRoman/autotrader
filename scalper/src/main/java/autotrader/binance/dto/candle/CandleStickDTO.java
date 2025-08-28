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
public class CandleStickDTO {
    @JsonProperty("t")
    private long openTime;
    @JsonProperty("T")
    private long closeTime;
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("i")
    private String interval;
    @JsonProperty("f")
    private long firstTradeID;
    @JsonProperty("L")
    private long lastTradeID;
    @JsonProperty("o")
    private double openPrice;
    @JsonProperty("c")
    private double closePrice;
    @JsonProperty("h")
    private double highPrice;
    @JsonProperty("l")
    private double lowPrice;
    @JsonProperty("v")
    private double volume;
    @JsonProperty("n")
    private int trades;
    @JsonProperty("x")
    private boolean isClosed;
    @JsonProperty("q")
    private double quoteAssetVolume;
    @JsonProperty("V")
    private double takerBaseAssetVolume;
    @JsonProperty("Q")
    private double takerQuoteAssetVolume;
    @JsonProperty("B")
    private int ignore;
}
