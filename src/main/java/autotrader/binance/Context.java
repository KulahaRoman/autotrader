package autotrader.binance;

import autotrader.binance.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Context {
    private Order buyOrder;
    private Order stopLossOrder;
    private Order sellOrder;
}