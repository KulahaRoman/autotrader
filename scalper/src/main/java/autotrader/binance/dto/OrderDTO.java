package autotrader.binance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("orderId")
    private long orderID;
    @JsonProperty("orderListId")
    private long orderListID;
    @JsonProperty("clientOrderId")
    private String clientOrderID;
    @JsonProperty("transactTime")
    private long transactionTime;
    @JsonProperty("price")
    private double price;
    @JsonProperty("status")
    private String status;
}
