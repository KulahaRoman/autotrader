package autotrader.binance.mapper;

import autotrader.binance.dto.BalanceDTO;
import autotrader.binance.model.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);
    
    BalanceDTO toDTO(Balance balance);

    Balance toModel(BalanceDTO balanceDTO);
}
