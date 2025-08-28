package autotrader.binance.mapper;

import autotrader.binance.dto.OrderDTO;
import autotrader.binance.model.Order;
import autotrader.binance.model.OrderStatus;

public class OrderMapper {
    public static OrderDTO toDTO(Order order) {
        var orderDTO = new OrderDTO();
        orderDTO.setOrderID(order.getOrderID());
        orderDTO.setOrderListID(order.getOrderListID());
        orderDTO.setClientOrderID(order.getClientOrderID());
        orderDTO.setSymbol(order.getSymbol());
        orderDTO.setPrice(order.getPrice());
        if (orderDTO.getStatus() != null) {
            orderDTO.setStatus(order.getStatus().toString());
        }
        orderDTO.setTransactionTime(order.getTransactionTime());

        return orderDTO;
    }

    public static Order toModel(OrderDTO orderDTO) {
        var order = new Order();
        order.setOrderID(orderDTO.getOrderID());
        order.setOrderListID(orderDTO.getOrderListID());
        order.setClientOrderID(orderDTO.getClientOrderID());
        order.setSymbol(orderDTO.getSymbol());
        order.setPrice(orderDTO.getPrice());
        if (orderDTO.getStatus() != null) {
            order.setStatus(OrderStatus.valueOf(orderDTO.getStatus()));
        }
        order.setTransactionTime(orderDTO.getTransactionTime());

        return order;
    }
}
