package autotrader.binance.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private String symbol;
    private long orderID;
    private long orderListID;
    private String clientOrderID;
    private long transactionTime;
    private double price;
    private OrderStatus status;
}
