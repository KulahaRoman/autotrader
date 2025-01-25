package autotrader.binance.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BalanceUpdateDTO extends UpdateDTO {
    private final String asset;
    private final double balanceDelta;
    private final long clearTime;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BalanceUpdateDTO(@JsonProperty("E") long eventTime,
                            @JsonProperty("a") String asset,
                            @JsonProperty("d") double balanceDelta,
                            @JsonProperty("T") long clearTime) {
        super("balanceUpdate", eventTime);
        this.asset = asset;
        this.balanceDelta = balanceDelta;
        this.clearTime = clearTime;
    }
}
