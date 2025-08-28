package autotrader.binance.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceDTO {
    @JsonAlias({"a", "asset"})
    private String asset;
    @JsonAlias({"f", "free"})
    private double free;
    @JsonAlias({"l", "locked"})
    private double locked;
}