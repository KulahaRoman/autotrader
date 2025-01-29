package autotrader.binance.dto.update;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "e")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccountUpdateDTO.class, name = "outboundAccountPosition"),
        @JsonSubTypes.Type(value = BalanceUpdateDTO.class, name = "balanceUpdate"),
        @JsonSubTypes.Type(value = OrderUpdateDTO.class, name = "executionReport")
})
public abstract class UpdateDTO {
    private String eventType;
}
