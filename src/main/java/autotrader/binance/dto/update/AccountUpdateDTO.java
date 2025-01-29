package autotrader.binance.dto.update;

import autotrader.binance.dto.BalanceDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountUpdateDTO extends UpdateDTO {
    private long eventTime;
    private long lastTimeUpdate;
    private List<BalanceDTO> balanceDTOS;

    public AccountUpdateDTO() {
        super("outboundAccountPosition");
    }

    @JsonCreator
    public AccountUpdateDTO(@JsonProperty("e") String eventType,
                            @JsonProperty("E") long eventTime,
                            @JsonProperty("u") long lastTimeUpdate,
                            @JsonProperty("B") List<BalanceDTO> balanceDTOS) {
        super(eventType);
        this.eventTime = eventTime;
        this.lastTimeUpdate = lastTimeUpdate;
        this.balanceDTOS = balanceDTOS;
    }
}
