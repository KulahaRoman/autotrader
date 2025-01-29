package autotrader.binance.mapper;

import autotrader.binance.dto.BalanceDTO;
import autotrader.binance.model.Balance;

public class BalanceMapper {
    public static BalanceDTO toDTO(Balance balance) {
        var balanceDTO = new BalanceDTO();
        balanceDTO.setAsset(balance.getAsset());
        balanceDTO.setFree(balance.getFree());
        balanceDTO.setLocked(balance.getLocked());

        return balanceDTO;
    }

    public static Balance toModel(BalanceDTO balanceDTO) {
        var balance = new Balance();
        balance.setAsset(balanceDTO.getAsset());
        balance.setFree(balanceDTO.getFree());
        balance.setLocked(balanceDTO.getLocked());

        return balance;
    }
}
