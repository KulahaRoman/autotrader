package autotrader.binance.dto.exchange;

import autotrader.binance.dto.exchange.filter.FilterDTO;
import autotrader.binance.dto.exchange.symbol.SymbolDTO;
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
public class ExchangeDTO {
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("serverTime")
    private long serverTime;
    @JsonProperty("rateLimits")
    private List<RateLimitDTO> rateLimits;
    @JsonProperty("exchangeFilters")
    private List<FilterDTO> exchangeFilters;
    @JsonProperty("symbols")
    private List<SymbolDTO> symbols;
    @JsonProperty("sors")
    private List<SORDTO> sors;
}
