package autotrader.binance.mapper;

import autotrader.binance.dto.account.AccountDTO;
import autotrader.binance.dto.account.CommissionRateDTO;
import autotrader.binance.model.account.Account;
import autotrader.binance.model.account.CommissionRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {BalanceMapper.class})
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO toDTO(Account account);

    Account toModel(AccountDTO accountDTO);

    CommissionRateDTO toDTO(CommissionRate commissionRate);

    CommissionRate toModel(CommissionRateDTO commissionRateDTO);
}
