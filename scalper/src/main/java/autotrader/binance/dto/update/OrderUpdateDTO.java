package autotrader.binance.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderUpdateDTO extends UpdateDTO {
    private long eventTime;
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
    private String currentExecutionType;
    private String currentOrderStatus;
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

    public OrderUpdateDTO() {
        super("executionReport");
    }

    @JsonCreator
    public OrderUpdateDTO(@JsonProperty("e") String eventType,
                          @JsonProperty("E") long eventTime,
                          @JsonProperty("s") String symbol,
                          @JsonProperty("c") String clientOrderID,
                          @JsonProperty("S") String side,
                          @JsonProperty("o") String orderType,
                          @JsonProperty("f") String timeInForce,
                          @JsonProperty("q") double orderQuantity,
                          @JsonProperty("p") double orderPrice,
                          @JsonProperty("P") double stopPrice,
                          @JsonProperty("F") double icebergQuantity,
                          @JsonProperty("g") long orderListID,
                          @JsonProperty("C") String originalClientOrderID,
                          @JsonProperty("x") String currentExecutionType,
                          @JsonProperty("X") String currentOrderStatus,
                          @JsonProperty("r") String orderRejectReason,
                          @JsonProperty("i") long orderID,
                          @JsonProperty("l") double lastExecutedQuantity,
                          @JsonProperty("z") double cumulativeFilledQuantity,
                          @JsonProperty("L") double lastExecutedPrice,
                          @JsonProperty("n") double commissionAmount,
                          @JsonProperty("N") String commissionAsset,
                          @JsonProperty("T") long transactionTime,
                          @JsonProperty("t") long tradeID,
                          @JsonProperty("v") long preventedMatchID,
                          @JsonProperty("w") boolean isOrderOnBook,
                          @JsonProperty("m") boolean isTradeMakerSide,
                          @JsonProperty("O") long orderCreationTime,
                          @JsonProperty("Z") double cumulativeQuoteAssetTransactedQuantity,
                          @JsonProperty("Y") double lastQuoteTransactedQuantity,
                          @JsonProperty("Q") double quoteOrderQuantity,
                          @JsonProperty("W") long workingTime,
                          @JsonProperty("V") String selfTradePreventionMode) {
        super(eventType);
        this.eventTime = eventTime;
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
}
