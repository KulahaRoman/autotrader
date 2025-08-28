package autotrader.binance.model.exchange.symbol.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Filter {
    private FilterType filterType;
}
