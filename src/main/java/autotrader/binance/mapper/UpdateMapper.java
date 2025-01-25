package autotrader.binance.mapper;

import autotrader.binance.dto.update.AccountUpdateDTO;
import autotrader.binance.dto.update.BalanceUpdateDTO;
import autotrader.binance.dto.update.OrderUpdateDTO;
import autotrader.binance.dto.update.UpdateDTO;
import autotrader.binance.model.Update;
import autotrader.binance.model.update.UpdateType;
import autotrader.binance.model.update.AccountUpdate;
import autotrader.binance.model.update.BalanceUpdate;
import autotrader.binance.model.update.OrderUpdate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {BalanceMapper.class}, subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface UpdateMapper {
    UpdateMapper INSTANCE = Mappers.getMapper(UpdateMapper.class);

    @Mapping(source = "updateType", target = "eventType", qualifiedByName = "toEventType")
    @Mapping(source = "updateTime", target = "eventTime")
    @SubclassMapping(source = OrderUpdate.class, target = OrderUpdateDTO.class)
    @SubclassMapping(source = BalanceUpdate.class, target = BalanceUpdateDTO.class)
    @SubclassMapping(source = AccountUpdate.class, target = AccountUpdateDTO.class)
    UpdateDTO toDTO(Update update);

    @Mapping(source = "eventType", target = "updateType", qualifiedByName = "toUpdateType")
    @Mapping(source = "eventTime", target = "updateTime")
    @SubclassMapping(source = OrderUpdateDTO.class, target = OrderUpdate.class)
    @SubclassMapping(source = AccountUpdateDTO.class, target = AccountUpdate.class)
    @SubclassMapping(source = BalanceUpdateDTO.class, target = BalanceUpdate.class)
    Update toModel(UpdateDTO updateDTO);

    @Named("toEventType")
    static String toEventType(UpdateType updateType) {
        return switch (updateType) {
            case ORDER -> "executionReport";
            case ACCOUNT -> "outboundAccountPosition";
            case BALANCE -> "balanceUpdate";
        };
    }

    @Named("toUpdateType")
    static UpdateType toUpdateType(String eventType) {
        return switch (eventType) {
            case "executionReport" -> UpdateType.ORDER;
            case "outboundAccountPosition" -> UpdateType.ACCOUNT;
            case "balanceUpdate" -> UpdateType.BALANCE;
            case null, default -> null;
        };
    }
}
