package autotrader.binance.dto.update;

import autotrader.binance.dto.BalanceDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AccountUpdateDTO extends UpdateDTO {
    private final long lastTimeUpdate;
    private final List<BalanceDTO> balanceDTOS;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AccountUpdateDTO(@JsonProperty("E") long eventTime,
                            @JsonProperty("u") long lastTimeUpdate,
                            @JsonProperty("B") List<BalanceDTO> balanceDTOS) {
        super("outboundAccountPosition", eventTime);
        this.lastTimeUpdate = lastTimeUpdate;
        this.balanceDTOS = balanceDTOS;
    }
}
