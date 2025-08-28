package autotrader.binance.dto.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SORDTO {
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("symbols")
    private List<String> symbols;
}
