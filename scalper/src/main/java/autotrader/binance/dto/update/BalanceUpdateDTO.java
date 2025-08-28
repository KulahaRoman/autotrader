package autotrader.binance.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceUpdateDTO extends UpdateDTO {
    private long eventTime;
    private String asset;
    private double balanceDelta;
    private long clearTime;

    public BalanceUpdateDTO(long eventTime) {
        super("balanceUpdate");
    }

    @JsonCreator
    public BalanceUpdateDTO(@JsonProperty("e") String eventType,
                            @JsonProperty("E") long eventTime,
                            @JsonProperty("a") String asset,
                            @JsonProperty("d") double balanceDelta,
                            @JsonProperty("T") long clearTime) {
        super(eventType);
        this.eventTime = eventTime;
        this.asset = asset;
        this.balanceDelta = balanceDelta;
        this.clearTime = clearTime;
    }
}
