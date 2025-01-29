package autotrader.binance.mapper;

import autotrader.binance.dto.account.AccountDTO;
import autotrader.binance.dto.account.CommissionRateDTO;
import autotrader.binance.model.account.Account;
import autotrader.binance.model.account.CommissionRate;

import java.util.stream.Collectors;

public class AccountMapper {
    public static AccountDTO toDTO(Account account) {
        var accountDTO = new AccountDTO();
        accountDTO.setUserID(account.getUserID());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBrokered(account.isBrokered());
        accountDTO.setCanDeposit(account.isCanDeposit());
        accountDTO.setCanTrade(account.isCanTrade());
        accountDTO.setCanWithdraw(account.isCanWithdraw());
        accountDTO.setBuyerCommission(account.getBuyerCommission());
        accountDTO.setSellerCommission(account.getSellerCommission());
        accountDTO.setPreventSor(account.isPreventSor());
        accountDTO.setMakerCommission(account.getMakerCommission());
        accountDTO.setTakerCommission(account.getTakerCommission());
        accountDTO.setRequireSelfTradePrevention(account.isRequireSelfTradePrevention());
        accountDTO.setUpdateTime(account.getUpdateTime());
        accountDTO.setCommissionRateDTO(toDTO(account.getCommissionRate()));
        accountDTO.setPermissions(account.getPermissions());
        if (account.getBalances() != null) {
            accountDTO.setBalanceDTOS(account.getBalances()
                    .stream().map(BalanceMapper::toDTO).collect(Collectors.toList()));
        }

        return accountDTO;
    }

    public static Account toModel(AccountDTO accountDTO) {
        var account = new Account();
        account.setUserID(account.getUserID());
        account.setAccountType(account.getAccountType());
        account.setBrokered(account.isBrokered());
        account.setCanDeposit(account.isCanDeposit());
        account.setCanTrade(account.isCanTrade());
        account.setCanWithdraw(account.isCanWithdraw());
        account.setBuyerCommission(account.getBuyerCommission());
        account.setSellerCommission(account.getSellerCommission());
        account.setPreventSor(account.isPreventSor());
        account.setMakerCommission(account.getMakerCommission());
        account.setTakerCommission(account.getTakerCommission());
        account.setRequireSelfTradePrevention(account.isRequireSelfTradePrevention());
        account.setUpdateTime(account.getUpdateTime());
        account.setCommissionRate(toModel(accountDTO.getCommissionRateDTO()));
        account.setPermissions(accountDTO.getPermissions());
        if (accountDTO.getBalanceDTOS() != null) {
            account.setBalances(accountDTO.getBalanceDTOS()
                    .stream().map(BalanceMapper::toModel).collect(Collectors.toList()));
        }

        return account;
    }

    private static CommissionRateDTO toDTO(CommissionRate commissionRate) {
        var commissionRateDTO = new CommissionRateDTO();
        commissionRateDTO.setBuyer(commissionRate.getBuyer());
        commissionRateDTO.setSeller(commissionRate.getSeller());
        commissionRateDTO.setTaker(commissionRate.getTaker());
        commissionRateDTO.setMaker(commissionRate.getMaker());

        return commissionRateDTO;
    }

    private static CommissionRate toModel(CommissionRateDTO commissionRateDTO) {
        var commissionRate = new CommissionRate();
        commissionRate.setBuyer(commissionRateDTO.getBuyer());
        commissionRate.setSeller(commissionRateDTO.getSeller());
        commissionRate.setTaker(commissionRateDTO.getTaker());
        commissionRate.setMaker(commissionRateDTO.getMaker());

        return commissionRate;
    }
}
