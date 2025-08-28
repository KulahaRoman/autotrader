package autotrader.binance;

import autotrader.binance.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Trade {
    private String symbol;
    private double price;
    private double amount;
}