package autotrader.binance.dto.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimitDTO {
    @JsonProperty("rateLimitType")
    private String rateLimitType;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("intervalNum")
    private int intervalNumber;
    @JsonProperty("limit")
    private int limit;
}
