package autotrader.binance;

import autotrader.binance.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Trade {
    private String symbol;
    private double price;
    private double amount;
}