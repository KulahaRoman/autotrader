package autotrader.binance.model.candle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CandleStick {
    private long openTime;
    private long closeTime;
    private String symbol;
    private String interval;
    private long firstTradeID;
    private long lastTradeID;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double lowPrice;
    private double volume;
    private int trades;
    private boolean isClosed;
    private double quoteAssetVolume;
    private double takerBaseAssetVolume;
    private double takerQuoteAssetVolume;
    private int ignore;
}
