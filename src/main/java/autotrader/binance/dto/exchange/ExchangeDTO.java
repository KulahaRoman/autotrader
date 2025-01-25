package autotrader.binance.dto.exchange;

import autotrader.binance.dto.exchange.filter.FilterDTO;
import autotrader.binance.dto.exchange.symbol.SymbolDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExchangeDTO {
    @JsonProperty("timezone")
    private final String timezone;
    @JsonProperty("serverTime")
    private final long serverTime;
    @JsonProperty("rateLimits")
    private final List<RateLimitDTO> rateLimits;
    @JsonProperty("exchangeFilters")
    private final List<FilterDTO> exchangeFilters;
    @JsonProperty("symbols")
    private final List<SymbolDTO> symbols;
    @JsonProperty("sors")
    private final List<SORDTO> sors;

    public List<RateLimitDTO> getRateLimits() {
        return Collections.unmodifiableList(rateLimits);
    }

    public List<FilterDTO> getExchangeFilters() {
        return Collections.unmodifiableList(exchangeFilters);
    }

    public List<SymbolDTO> getSymbols() {
        return Collections.unmodifiableList(symbols);
    }

    public List<SORDTO> getSors() {
        return Collections.unmodifiableList(sors);
    }
}
