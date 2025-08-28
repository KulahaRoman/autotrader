package autotrader.binance.model.candle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CandleStickEvent {
    private String eventType;
    private long eventTime;
    private String symbol;
    private CandleStick candleStick;
}
