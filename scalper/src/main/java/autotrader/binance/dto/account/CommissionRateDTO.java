package autotrader.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommissionRateDTO {
    @JsonProperty("maker")
    private double maker;
    @JsonProperty("taker")
    private double taker;
    @JsonProperty("buyer")
    private double buyer;
    @JsonProperty("seller")
    private double seller;
}