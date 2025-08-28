package autotrader.binance.model.update;

import autotrader.binance.model.OrderStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderUpdate extends Update {
    private String symbol;
    private String clientOrderID;
    private String side;
    private String orderType;
    private String timeInForce;
    private double orderQuantity;
    private double orderPrice;
    private double stopPrice;
    private double icebergQuantity;
    private long orderListID;
    private String originalClientOrderID;
    private ExecutionType currentExecutionType;
    private OrderStatus currentOrderStatus;
    private String orderRejectReason;
    private long orderID;
    private double lastExecutedQuantity;
    private double cumulativeFilledQuantity;
    private double lastExecutedPrice;
    private double commissionAmount;
    private String commissionAsset;
    private long transactionTime;
    private long tradeID;
    private long preventedMatchID;
    private boolean isOrderOnBook;
    private boolean isTradeMakerSide;
    private long orderCreationTime;
    private double cumulativeQuoteAssetTransactedQuantity;
    private double lastQuoteTransactedQuantity;
    private double quoteOrderQuantity;
    private long workingTime;
    private String selfTradePreventionMode;

    public OrderUpdate(long updateTime) {
        super(UpdateType.ORDER, updateTime);
    }

    public OrderUpdate(long updateTime, String symbol, String clientOrderID,
                       String side, String orderType, String timeInForce, double orderQuantity,
                       double orderPrice, double stopPrice, double icebergQuantity,
                       long orderListID, String originalClientOrderID, ExecutionType currentExecutionType,
                       OrderStatus currentOrderStatus, String orderRejectReason, long orderID,
                       double lastExecutedQuantity, double cumulativeFilledQuantity, double lastExecutedPrice,
                       double commissionAmount, String commissionAsset, long transactionTime,
                       long tradeID, long preventedMatchID, boolean isOrderOnBook,
                       boolean isTradeMakerSide, long orderCreationTime, double cumulativeQuoteAssetTransactedQuantity,
                       double lastQuoteTransactedQuantity, double quoteOrderQuantity,
                       long workingTime, String selfTradePreventionMode) {
        super(UpdateType.ORDER, updateTime);
        this.symbol = symbol;
        this.clientOrderID = clientOrderID;
        this.side = side;
        this.orderType = orderType;
        this.timeInForce = timeInForce;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.stopPrice = stopPrice;
        this.icebergQuantity = icebergQuantity;
        this.orderListID = orderListID;
        this.originalClientOrderID = originalClientOrderID;
        this.currentExecutionType = currentExecutionType;
        this.currentOrderStatus = currentOrderStatus;
        this.orderRejectReason = orderRejectReason;
        this.orderID = orderID;
        this.lastExecutedQuantity = lastExecutedQuantity;
        this.cumulativeFilledQuantity = cumulativeFilledQuantity;
        this.lastExecutedPrice = lastExecutedPrice;
        this.commissionAmount = commissionAmount;
        this.commissionAsset = commissionAsset;
        this.transactionTime = transactionTime;
        this.tradeID = tradeID;
        this.preventedMatchID = preventedMatchID;
        this.isOrderOnBook = isOrderOnBook;
        this.isTradeMakerSide = isTradeMakerSide;
        this.orderCreationTime = orderCreationTime;
        this.cumulativeQuoteAssetTransactedQuantity = cumulativeQuoteAssetTransactedQuantity;
        this.lastQuoteTransactedQuantity = lastQuoteTransactedQuantity;
        this.quoteOrderQuantity = quoteOrderQuantity;
        this.workingTime = workingTime;
        this.selfTradePreventionMode = selfTradePreventionMode;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ExecutionType {
        NEW("The order has been accepted into the engine."),
        CANCELED("The order has been canceled by the user."),
        REPLACED("(currently unused)"),
        REJECTED("The order has been rejected and was not processed."),
        TRADE("Part of the order or all of the order's quantity has filled."),
        EXPIRED("The order was canceled according to the order type's rules."),
        TRADE_PREVENTION("The order has expired due to STP.");

        private final String description;
    }
}
