package autotrader.binance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    NEW("The order has been accepted by the engine."),
    PENDING_NEW(" The order is in a pending phase until the working order of an order " +
            "list has been fully filled."),
    PARTIALLY_FILLED("A part of the order has been filled."),
    FILLED("The order has been completed."),
    CANCELED("The order has been canceled by the user."),
    PENDING_CANCEL("Currently unused"),
    REJECTED("The order was not accepted by the engine and not processed."),
    EXPIRED("The order was canceled according to the order type's rules " +
            "(e.g. LIMIT FOK orders with no fill, LIMIT IOC or MARKET orders that partially fill)\n" +
            "or by the exchange, (e.g. orders canceled during liquidation, orders canceled during maintenance)"),
    EXPIRED_IN_MATCH("The order was expired by the exchange due to STP. " +
            "(e.g. an order with EXPIRE_TAKER will match with existing orders on the " +
            "book with the same account or same tradeGroupId)");

    private final String description;
}