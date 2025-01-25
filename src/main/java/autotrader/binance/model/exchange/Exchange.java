package autotrader.binance.model.exchange;

import autotrader.binance.model.exchange.filter.Filter;
import autotrader.binance.model.exchange.symbol.Symbol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Exchange {
    private String timezone;
    private long serverTime;
    private List<RateLimit> rateLimits;
    private List<Filter> exchangeFilters;
    private List<Symbol> symbols;
    private List<SOR> sors;
}
