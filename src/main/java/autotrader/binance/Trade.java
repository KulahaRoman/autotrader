package autotrader.binance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Trade {
    private TradeType type;
    private String symbol;
    private double price;
    private double amount;
}