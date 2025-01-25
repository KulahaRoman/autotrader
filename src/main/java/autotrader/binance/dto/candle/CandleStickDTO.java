package autotrader.binance.dto.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CandleStickDTO {
    @JsonProperty("t")
    private final long openTime;
    @JsonProperty("T")
    private final long closeTime;
    @JsonProperty("s")
    private final String symbol;
    @JsonProperty("i")
    private final String interval;
    @JsonProperty("f")
    private final long firstTradeID;
    @JsonProperty("L")
    private final long lastTradeID;
    @JsonProperty("o")
    private final double openPrice;
    @JsonProperty("c")
    private final double closePrice;
    @JsonProperty("h")
    private final double highPrice;
    @JsonProperty("l")
    private final double lowPrice;
    @JsonProperty("v")
    private final double volume;
    @JsonProperty("n")
    private final int trades;
    @JsonProperty("x")
    private final boolean isClosed;
    @JsonProperty("q")
    private final double quoteAssetVolume;
    @JsonProperty("V")
    private final double takerBaseAssetVolume;
    @JsonProperty("Q")
    private final double takerQuoteAssetVolume;
    @JsonProperty("B")
    private final int ignore;
}
