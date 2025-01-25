package autotrader.binance.model.exchange;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RateLimit {
    private String rateLimitType;
    private String interval;
    private int intervalNumber;
    private int limit;
}
