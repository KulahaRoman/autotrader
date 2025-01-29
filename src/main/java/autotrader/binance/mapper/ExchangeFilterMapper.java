package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberAlgoOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberIcebergOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.FilterDTO;
import autotrader.binance.model.exchange.filter.*;

public class ExchangeFilterMapper {
    public static FilterDTO toDTO(Filter filter) {
        return switch (filter) {
            case ExchangeMaxNumberAlgoOrdersFilter f -> toDTO(f);
            case ExchangeMaxNumberIcebergOrdersFilter f -> toDTO(f);
            case ExchangeMaxNumberOrdersFilter f -> toDTO(f);
            case null, default -> throw new IllegalStateException("Invalid filter value: " + filter);
        };
    }

    public static Filter toModel(FilterDTO filterDTO) {
        return switch (filterDTO) {
            case ExchangeMaxNumberAlgoOrdersFilterDTO f -> toModel(f);
            case ExchangeMaxNumberIcebergOrdersFilterDTO f -> toModel(f);
            case ExchangeMaxNumberOrdersFilterDTO f -> toModel(f);
            case null, default -> throw new IllegalStateException("Invalid filter value: " + filterDTO);
        };
    }

    private static FilterDTO toDTO(ExchangeMaxNumberAlgoOrdersFilter filter) {
        var filterDTO = new ExchangeMaxNumberAlgoOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberAlgoOrders(filter.getMaxNumberAlgoOrders());

        return filterDTO;
    }

    private static FilterDTO toDTO(ExchangeMaxNumberOrdersFilter filter) {
        var filterDTO = new ExchangeMaxNumberOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberOrders(filter.getMaxNumberOrders());

        return filterDTO;
    }

    private static FilterDTO toDTO(ExchangeMaxNumberIcebergOrdersFilter filter) {
        var filterDTO = new ExchangeMaxNumberIcebergOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberIcebergOrders(filter.getMaxNumberIcebergOrders());

        return filterDTO;
    }

    private static Filter toModel(ExchangeMaxNumberAlgoOrdersFilterDTO filterDTO) {
        var filter = new ExchangeMaxNumberIcebergOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberIcebergOrders(filterDTO.getMaxNumberAlgoOrders());

        return filter;
    }

    private static Filter toModel(ExchangeMaxNumberOrdersFilterDTO filterDTO) {
        var filter = new ExchangeMaxNumberOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberOrders(filterDTO.getMaxNumberOrders());

        return filter;
    }

    private static Filter toModel(ExchangeMaxNumberIcebergOrdersFilterDTO filterDTO) {
        var filter = new ExchangeMaxNumberIcebergOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberIcebergOrders(filterDTO.getMaxNumberIcebergOrders());

        return filter;
    }
}
