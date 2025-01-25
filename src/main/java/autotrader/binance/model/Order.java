package autotrader.binance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private String symbol;
    private long orderID;
    private long orderListID;
    private String clientOrderID;
    private long transactionTime;
}
