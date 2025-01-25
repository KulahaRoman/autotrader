package autotrader.binance.model.exchange.symbol.filter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Filter {
    private final FilterType filterType;
}
