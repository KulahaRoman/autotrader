package autotrader.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommissionRateDTO {
    @JsonProperty("maker")
    private final double maker;
    @JsonProperty("taker")
    private final double taker;
    @JsonProperty("buyer")
    private final double buyer;
    @JsonProperty("seller")
    private final double seller;
}