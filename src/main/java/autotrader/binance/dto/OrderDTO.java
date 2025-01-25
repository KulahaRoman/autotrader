package autotrader.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderDTO {
    @JsonProperty("symbol")
    private final String symbol;
    @JsonProperty("orderId")
    private final long orderID;
    @JsonProperty("orderListId")
    private final long orderListID;
    @JsonProperty("clientOrderId")
    private final String clientOrderID;
    @JsonProperty("transactTime")
    private final long transactionTime;
}
