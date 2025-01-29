package autotrader.binance.model.exchange.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Filter {
    private FilterType filterType;
}
