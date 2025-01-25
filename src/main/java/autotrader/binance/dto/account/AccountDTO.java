package autotrader.binance.dto.account;

import autotrader.binance.dto.BalanceDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class AccountDTO {
    @JsonProperty("makerCommission")
    private final int makerCommission;
    @JsonProperty("takerCommission")
    private final int takerCommission;
    @JsonProperty("buyerCommission")
    private final int buyerCommission;
    @JsonProperty("sellerCommission")
    private final int sellerCommission;
    @JsonProperty("commissionRates")
    private final CommissionRateDTO commissionRateDTO;
    @JsonProperty("canTrade")
    private final boolean canTrade;
    @JsonProperty("canWithdraw")
    private final boolean canWithdraw;
    @JsonProperty("canDeposit")
    private final boolean canDeposit;
    @JsonProperty("brokered")
    private final boolean brokered;
    @JsonProperty("requireSelfTradePrevention")
    private final boolean requireSelfTradePrevention;
    @JsonProperty("preventSor")
    private final boolean preventSor;
    @JsonProperty("updateTime")
    private final long updateTime;
    @JsonProperty("accountType")
    private final String accountType;
    @JsonProperty("balances")
    private final List<BalanceDTO> balanceDTOS;
    @JsonProperty("permissions")
    private final List<String> permissions;
    @JsonProperty("uid")
    private final long userID;
}
