package autotrader.binance.dto.account;

import autotrader.binance.dto.BalanceDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {
    @JsonProperty("makerCommission")
    private int makerCommission;
    @JsonProperty("takerCommission")
    private int takerCommission;
    @JsonProperty("buyerCommission")
    private int buyerCommission;
    @JsonProperty("sellerCommission")
    private int sellerCommission;
    @JsonProperty("commissionRates")
    private CommissionRateDTO commissionRateDTO;
    @JsonProperty("canTrade")
    private boolean canTrade;
    @JsonProperty("canWithdraw")
    private boolean canWithdraw;
    @JsonProperty("canDeposit")
    private boolean canDeposit;
    @JsonProperty("brokered")
    private boolean brokered;
    @JsonProperty("requireSelfTradePrevention")
    private boolean requireSelfTradePrevention;
    @JsonProperty("preventSor")
    private boolean preventSor;
    @JsonProperty("updateTime")
    private long updateTime;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("balances")
    private List<BalanceDTO> balanceDTOS;
    @JsonProperty("permissions")
    private List<String> permissions;
    @JsonProperty("uid")
    private long userID;
}
