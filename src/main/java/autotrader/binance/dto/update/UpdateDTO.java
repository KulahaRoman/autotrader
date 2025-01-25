package autotrader.binance.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "eventType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccountUpdateDTO.class, name = "outboundAccountPosition"),
        @JsonSubTypes.Type(value = BalanceUpdateDTO.class, name = "balanceUpdate"),
        @JsonSubTypes.Type(value = OrderUpdateDTO.class, name = "executionReport")
})
public abstract class UpdateDTO {
    @JsonProperty("e")
    private final String eventType;
    @JsonProperty("E")
    private final long eventTime;
}
