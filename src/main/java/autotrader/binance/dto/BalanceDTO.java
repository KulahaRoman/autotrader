package autotrader.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BalanceDTO {
    @JsonProperty("asset")
    private final String asset;
    @JsonProperty("free")
    private final double free;
    @JsonProperty("locked")
    private final double locked;
}