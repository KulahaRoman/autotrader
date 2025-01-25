package autotrader.binance.model.account;

import autotrader.binance.model.Balance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    private int makerCommission;
    private int takerCommission;
    private int buyerCommission;
    private int sellerCommission;
    private CommissionRate commissionRate;
    private boolean canTrade;
    private boolean canWithdraw;
    private boolean canDeposit;
    private boolean brokered;
    private boolean requireSelfTradePrevention;
    private boolean preventSor;
    private long updateTime;
    private String accountType;
    private List<Balance> balances;
    private List<String> permissions;
    private long userID;
}
