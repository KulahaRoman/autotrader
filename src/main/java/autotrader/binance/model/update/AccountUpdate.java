package autotrader.binance.model.update;

import autotrader.binance.model.Balance;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountUpdate extends Update {
    private long lastTimeUpdate;
    private List<Balance> balances;

    public AccountUpdate(long updateTime) {
        super(UpdateType.ACCOUNT, updateTime);
    }

    public AccountUpdate(long updateTime, long lastTimeUpdate, List<Balance> balances) {
        super(UpdateType.ACCOUNT, updateTime);
        this.lastTimeUpdate = lastTimeUpdate;
        this.balances = balances;
    }
}
