package autotrader.binance.model.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceUpdate extends Update {
    private String asset;
    private double balanceDelta;
    private long clearTime;

    public BalanceUpdate(long updateTime, String asset, double balanceDelta, long clearTime) {
        super(UpdateType.BALANCE, updateTime);
        this.asset = asset;
        this.balanceDelta = balanceDelta;
        this.clearTime = clearTime;
    }
}
