package autotrader.binance.mapper;

import autotrader.binance.dto.OrderDTO;
import autotrader.binance.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);

    Order toModel(OrderDTO orderDTO);
}
