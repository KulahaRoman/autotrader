package autotrader.binance.mapper;

import autotrader.binance.dto.update.AccountUpdateDTO;
import autotrader.binance.dto.update.BalanceUpdateDTO;
import autotrader.binance.dto.update.OrderUpdateDTO;
import autotrader.binance.dto.update.UpdateDTO;
import autotrader.binance.model.OrderStatus;
import autotrader.binance.model.update.AccountUpdate;
import autotrader.binance.model.update.BalanceUpdate;
import autotrader.binance.model.update.OrderUpdate;
import autotrader.binance.model.update.Update;

import java.util.stream.Collectors;

public class UpdateMapper {
    public static UpdateDTO toDTO(Update update) {
        return switch (update) {
            case AccountUpdate u -> toDTO(u);
            case BalanceUpdate u -> toDTO(u);
            case OrderUpdate o -> toDTO(o);
            case null, default -> throw new IllegalArgumentException("Invalid update type");
        };
    }

    public static Update toModel(UpdateDTO updateDTO) {
        return switch (updateDTO) {
            case AccountUpdateDTO u -> toModel(u);
            case BalanceUpdateDTO u -> toModel(u);
            case OrderUpdateDTO o -> toModel(o);
            case null, default -> throw new IllegalArgumentException("Invalid update type");
        };
    }

    private static UpdateDTO toDTO(AccountUpdate update) {
        var updateDTO = new AccountUpdateDTO();
        updateDTO.setEventTime(update.getTime());
        updateDTO.setLastTimeUpdate(update.getTime());
        if (update.getBalances() != null) {
            updateDTO.setBalanceDTOS(update.getBalances()
                    .stream().map(BalanceMapper::toDTO).collect(Collectors.toList()));
        }

        return updateDTO;
    }

    private static UpdateDTO toDTO(BalanceUpdate update) {
        var updateDTO = new BalanceUpdateDTO(update.getTime());
        updateDTO.setAsset(update.getAsset());
        updateDTO.setClearTime(update.getClearTime());
        updateDTO.setBalanceDelta(update.getBalanceDelta());

        return updateDTO;
    }

    private static UpdateDTO toDTO(OrderUpdate update) {
        var updateDTO = new OrderUpdateDTO();
        updateDTO.setEventTime(update.getTime());
        updateDTO.setSymbol(update.getSymbol());
        updateDTO.setClientOrderID(update.getClientOrderID());
        updateDTO.setSide(update.getSide());
        updateDTO.setOrderType(update.getOrderType());
        updateDTO.setTimeInForce(update.getTimeInForce());
        updateDTO.setOrderQuantity(update.getOrderQuantity());
        updateDTO.setOrderPrice(update.getOrderPrice());
        updateDTO.setStopPrice(update.getStopPrice());
        updateDTO.setIcebergQuantity(update.getIcebergQuantity());
        updateDTO.setOrderListID(update.getOrderListID());
        updateDTO.setOriginalClientOrderID(update.getOriginalClientOrderID());
        updateDTO.setCurrentExecutionType(update.getCurrentExecutionType().toString());
        updateDTO.setCurrentOrderStatus(update.getCurrentOrderStatus().toString());
        updateDTO.setOrderRejectReason(update.getOrderRejectReason());
        updateDTO.setOrderID(update.getOrderID());
        updateDTO.setLastExecutedQuantity(update.getLastExecutedQuantity());
        updateDTO.setCumulativeFilledQuantity(update.getCumulativeFilledQuantity());
        updateDTO.setLastExecutedPrice(update.getLastExecutedPrice());
        updateDTO.setCommissionAmount(update.getCommissionAmount());
        updateDTO.setCommissionAsset(update.getCommissionAsset());
        updateDTO.setTransactionTime(update.getTransactionTime());
        updateDTO.setTradeID(update.getTradeID());
        updateDTO.setPreventedMatchID(update.getPreventedMatchID());
        updateDTO.setOrderOnBook(update.isOrderOnBook());
        updateDTO.setTradeMakerSide(update.isTradeMakerSide());
        updateDTO.setOrderCreationTime(update.getOrderCreationTime());
        updateDTO.setCumulativeQuoteAssetTransactedQuantity(update.getCumulativeQuoteAssetTransactedQuantity());
        updateDTO.setLastQuoteTransactedQuantity(update.getLastQuoteTransactedQuantity());
        updateDTO.setQuoteOrderQuantity(update.getQuoteOrderQuantity());
        updateDTO.setWorkingTime(update.getWorkingTime());
        updateDTO.setSelfTradePreventionMode(update.getSelfTradePreventionMode());

        return updateDTO;
    }

    private static Update toModel(AccountUpdateDTO updateDTO) {
        var update = new AccountUpdate(updateDTO.getEventTime());
        update.setLastTimeUpdate(updateDTO.getLastTimeUpdate());
        if (updateDTO.getBalanceDTOS() != null) {
            update.setBalances(updateDTO.getBalanceDTOS()
                    .stream().map(BalanceMapper::toModel).collect(Collectors.toList()));
        }

        return update;
    }

    private static Update toModel(BalanceUpdateDTO updateDTO) {
        var update = new BalanceUpdate(updateDTO.getEventTime());
        update.setAsset(updateDTO.getAsset());
        update.setClearTime(updateDTO.getClearTime());
        update.setBalanceDelta(updateDTO.getBalanceDelta());

        return update;
    }

    private static Update toModel(OrderUpdateDTO updateDTO) {
        var update = new OrderUpdate(updateDTO.getEventTime());
        update.setSymbol(updateDTO.getSymbol());
        update.setClientOrderID(updateDTO.getClientOrderID());
        update.setSide(updateDTO.getSide());
        update.setOrderType(updateDTO.getOrderType());
        update.setTimeInForce(updateDTO.getTimeInForce());
        update.setOrderQuantity(updateDTO.getOrderQuantity());
        update.setOrderPrice(updateDTO.getOrderPrice());
        update.setStopPrice(updateDTO.getStopPrice());
        update.setIcebergQuantity(updateDTO.getIcebergQuantity());
        update.setOrderListID(updateDTO.getOrderListID());
        update.setOriginalClientOrderID(updateDTO.getOriginalClientOrderID());
        update.setCurrentExecutionType(OrderUpdate.ExecutionType.valueOf(updateDTO.getCurrentExecutionType()));
        update.setCurrentOrderStatus(OrderStatus.valueOf(updateDTO.getCurrentOrderStatus()));
        update.setOrderRejectReason(updateDTO.getOrderRejectReason());
        update.setOrderID(updateDTO.getOrderID());
        update.setLastExecutedQuantity(updateDTO.getLastExecutedQuantity());
        update.setCumulativeFilledQuantity(updateDTO.getCumulativeFilledQuantity());
        update.setLastExecutedPrice(updateDTO.getLastExecutedPrice());
        update.setCommissionAmount(updateDTO.getCommissionAmount());
        update.setCommissionAsset(updateDTO.getCommissionAsset());
        update.setTransactionTime(updateDTO.getTransactionTime());
        update.setTradeID(updateDTO.getTradeID());
        update.setPreventedMatchID(updateDTO.getPreventedMatchID());
        update.setOrderOnBook(updateDTO.isOrderOnBook());
        update.setTradeMakerSide(updateDTO.isTradeMakerSide());
        update.setOrderCreationTime(updateDTO.getOrderCreationTime());
        update.setCumulativeQuoteAssetTransactedQuantity(updateDTO.getCumulativeQuoteAssetTransactedQuantity());
        update.setLastQuoteTransactedQuantity(updateDTO.getLastQuoteTransactedQuantity());
        update.setQuoteOrderQuantity(updateDTO.getQuoteOrderQuantity());
        update.setWorkingTime(updateDTO.getWorkingTime());
        update.setSelfTradePreventionMode(updateDTO.getSelfTradePreventionMode());

        return update;
    }
}
