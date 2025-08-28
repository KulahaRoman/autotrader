package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.symbol.filter.*;
import autotrader.binance.model.exchange.symbol.filter.*;

public class SymbolFilterMapper {
    public static FilterDTO toDTO(Filter filter) {
        return switch (filter) {
            case IcebergPartsFilter sf -> toDTO(sf);
            case LotSizeFilter sf -> toDTO(sf);
            case MarketLotSizeFilter sf -> toDTO(sf);
            case MaxNumberAlgoOrdersFilter sf -> toDTO(sf);
            case MaxNumberIcebergOrdersFilter sf -> toDTO(sf);
            case MaxNumberOrdersFilter sf -> toDTO(sf);
            case MaxPositionFilter sf -> toDTO(sf);
            case MinimalNotionalFilter sf -> toDTO(sf);
            case NotionalFilter sf -> toDTO(sf);
            case PercentPriceBySideFilter sf -> toDTO(sf);
            case PercentPriceFilter sf -> toDTO(sf);
            case PriceFilter sf -> toDTO(sf);
            case TrailingDeltaFilter sf -> toDTO(sf);
            case null, default -> throw new IllegalStateException("Invalid symbol filter type: " + filter);
        };
    }

    public static Filter toModel(FilterDTO filterDTO) {
        return switch (filterDTO) {
            case IcebergPartsFilterDTO sf -> toModel(sf);
            case LotSizeFilterDTO sf -> toModel(sf);
            case MarketLotSizeFilterDTO sf -> toModel(sf);
            case MaxNumberAlgoOrdersFilterDTO sf -> toModel(sf);
            case MaxNumberIcebergOrdersFilterDTO sf -> toModel(sf);
            case MaxNumberOrdersFilterDTO sf -> toModel(sf);
            case MaxPositionFilterDTO sf -> toModel(sf);
            case MinimalNotionalFilterDTO sf -> toModel(sf);
            case NotionalFilterDTO sf -> toModel(sf);
            case PercentPriceBySideFilterDTO sf -> toModel(sf);
            case PercentPriceFilterDTO sf -> toModel(sf);
            case PriceFilterDTO sf -> toModel(sf);
            case TrailingDeltaFilterDTO sf -> toModel(sf);
            case null, default -> throw new IllegalStateException("Invalid symbol filter type: " + filterDTO);
        };
    }

    private static FilterDTO toDTO(IcebergPartsFilter filter) {
        var filterDTO = new IcebergPartsFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setLimit(filter.getLimit());

        return filterDTO;
    }

    private static FilterDTO toDTO(LotSizeFilter filter) {
        var filterDTO = new LotSizeFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxQuantity(filter.getMaxQuantity());
        filterDTO.setMinQuantity(filter.getMinQuantity());
        filterDTO.setStepSize(filter.getStepSize());

        return filterDTO;
    }

    private static FilterDTO toDTO(MarketLotSizeFilter filter) {
        var filterDTO = new MarketLotSizeFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxQuantity(filter.getMaxQuantity());
        filterDTO.setMinQuantity(filter.getMinQuantity());
        filterDTO.setStepSize(filter.getStepSize());

        return filterDTO;
    }

    private static FilterDTO toDTO(MaxNumberAlgoOrdersFilter filter) {
        var filterDTO = new MaxNumberAlgoOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberAlgoOrders(filter.getMaxNumberAlgoOrders());

        return filterDTO;
    }

    private static FilterDTO toDTO(MaxNumberIcebergOrdersFilter filter) {
        var filterDTO = new MaxNumberIcebergOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberIcebergOrders(filter.getMaxNumberIcebergOrders());

        return filterDTO;
    }

    private static FilterDTO toDTO(MaxNumberOrdersFilter filter) {
        var filterDTO = new MaxNumberOrdersFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxNumberOrders(filter.getMaxNumberOrders());

        return filterDTO;
    }

    private static FilterDTO toDTO(MaxPositionFilter filter) {
        var filterDTO = new MaxPositionFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxPosition(filter.getMaxPosition());

        return filterDTO;
    }

    private static FilterDTO toDTO(MinimalNotionalFilter filter) {
        var filterDTO = new MinimalNotionalFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMinNotional(filter.getMinNotional());
        filterDTO.setApplyToMarket(filter.isApplyToMarket());
        filterDTO.setAveragePriceMinimums(filter.getAveragePriceMinimums());

        return filterDTO;
    }

    private static FilterDTO toDTO(NotionalFilter filter) {
        var filterDTO = new NotionalFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMinNotional(filter.getMinNotional());
        filterDTO.setMaxNotional(filter.getMaxNotional());
        filterDTO.setApplyMaxToMarket(filter.isApplyMaxToMarket());
        filterDTO.setAveragePriceMinimums(filter.getAveragePriceMinimums());
        filterDTO.setApplyMinToMarket(filter.isApplyMinToMarket());

        return filterDTO;
    }

    private static FilterDTO toDTO(PercentPriceBySideFilter filter) {
        var filterDTO = new PercentPriceBySideFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setAskMultiplierDown(filter.getAskMultiplierDown());
        filterDTO.setAskMultiplierUp(filter.getAskMultiplierUp());
        filterDTO.setBidMultiplierDown(filter.getBidMultiplierDown());
        filterDTO.setBidMultiplierUp(filter.getBidMultiplierUp());
        filterDTO.setAveragePriceMinimums(filter.getAveragePriceMinimums());

        return filterDTO;
    }

    private static FilterDTO toDTO(PercentPriceFilter filter) {
        var filterDTO = new PercentPriceFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setAveragePriceMinimums(filter.getAveragePriceMinimums());
        filterDTO.setMultiplierUp(filter.getMultiplierUp());
        filterDTO.setMultiplierDown(filter.getMultiplierDown());

        return filterDTO;
    }

    private static FilterDTO toDTO(PriceFilter filter) {
        var filterDTO = new PriceFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxPrice(filter.getMaxPrice());
        filterDTO.setMinPrice(filter.getMinPrice());
        filterDTO.setTickSize(filter.getTickSize());

        return filterDTO;
    }

    private static FilterDTO toDTO(TrailingDeltaFilter filter) {
        var filterDTO = new TrailingDeltaFilterDTO();
        filterDTO.setFilterType(filter.getFilterType().toString());
        filterDTO.setMaxTrailingAboveDelta(filter.getMaxTrailingAboveDelta());
        filterDTO.setMinTrailingAboveDelta(filter.getMinTrailingAboveDelta());
        filterDTO.setMaxTrailingBelowDelta(filter.getMaxTrailingBelowDelta());
        filterDTO.setMinTrailingBelowDelta(filter.getMinTrailingBelowDelta());

        return filterDTO;
    }

    private static Filter toModel(IcebergPartsFilterDTO filterDTO) {
        var filter = new IcebergPartsFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setLimit(filterDTO.getLimit());

        return filter;
    }

    private static Filter toModel(LotSizeFilterDTO filterDTO) {
        var filter = new LotSizeFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxQuantity(filterDTO.getMaxQuantity());
        filter.setMinQuantity(filterDTO.getMinQuantity());
        filter.setStepSize(filterDTO.getStepSize());

        return filter;
    }

    private static Filter toModel(MarketLotSizeFilterDTO filterDTO) {
        var filter = new MarketLotSizeFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxQuantity(filterDTO.getMaxQuantity());
        filter.setMinQuantity(filterDTO.getMinQuantity());
        filter.setStepSize(filterDTO.getStepSize());

        return filter;
    }

    private static Filter toModel(MaxNumberAlgoOrdersFilterDTO filterDTO) {
        var filter = new MaxNumberAlgoOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberAlgoOrders(filterDTO.getMaxNumberAlgoOrders());

        return filter;
    }

    private static Filter toModel(MaxNumberIcebergOrdersFilterDTO filterDTO) {
        var filter = new MaxNumberIcebergOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberIcebergOrders(filterDTO.getMaxNumberIcebergOrders());

        return filter;
    }

    private static Filter toModel(MaxNumberOrdersFilterDTO filterDTO) {
        var filter = new MaxNumberOrdersFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxNumberOrders(filterDTO.getMaxNumberOrders());

        return filter;
    }

    private static Filter toModel(MaxPositionFilterDTO filterDTO) {
        var filter = new MaxPositionFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxPosition(filterDTO.getMaxPosition());

        return filter;
    }

    private static Filter toModel(MinimalNotionalFilterDTO filterDTO) {
        var filter = new MinimalNotionalFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMinNotional(filterDTO.getMinNotional());
        filter.setApplyToMarket(filterDTO.isApplyToMarket());
        filter.setAveragePriceMinimums(filterDTO.getAveragePriceMinimums());

        return filter;
    }

    private static Filter toModel(NotionalFilterDTO filterDTO) {
        var filter = new NotionalFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMinNotional(filterDTO.getMinNotional());
        filter.setMaxNotional(filterDTO.getMaxNotional());
        filter.setApplyMaxToMarket(filterDTO.isApplyMaxToMarket());
        filter.setAveragePriceMinimums(filterDTO.getAveragePriceMinimums());
        filter.setApplyMinToMarket(filterDTO.isApplyMinToMarket());

        return filter;
    }

    private static Filter toModel(PercentPriceBySideFilterDTO filterDTO) {
        var filter = new PercentPriceBySideFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setAskMultiplierDown(filterDTO.getAskMultiplierDown());
        filter.setAskMultiplierUp(filterDTO.getAskMultiplierUp());
        filter.setBidMultiplierDown(filterDTO.getBidMultiplierDown());
        filter.setBidMultiplierUp(filterDTO.getBidMultiplierUp());
        filter.setAveragePriceMinimums(filterDTO.getAveragePriceMinimums());

        return filter;
    }

    private static Filter toModel(PercentPriceFilterDTO filterDTO) {
        var filter = new PercentPriceFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setAveragePriceMinimums(filterDTO.getAveragePriceMinimums());
        filter.setMultiplierUp(filterDTO.getMultiplierUp());
        filter.setMultiplierDown(filterDTO.getMultiplierDown());

        return filter;
    }

    private static Filter toModel(PriceFilterDTO filterDTO) {
        var filter = new PriceFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxPrice(filterDTO.getMaxPrice());
        filter.setMinPrice(filterDTO.getMinPrice());
        filter.setTickSize(filterDTO.getTickSize());

        return filter;
    }

    private static Filter toModel(TrailingDeltaFilterDTO filterDTO) {
        var filter = new TrailingDeltaFilter();
        filter.setFilterType(FilterType.valueOf(filterDTO.getFilterType()));
        filter.setMaxTrailingAboveDelta(filterDTO.getMaxTrailingAboveDelta());
        filter.setMinTrailingAboveDelta(filterDTO.getMinTrailingAboveDelta());
        filter.setMaxTrailingBelowDelta(filterDTO.getMaxTrailingBelowDelta());
        filter.setMinTrailingBelowDelta(filterDTO.getMinTrailingBelowDelta());

        return filter;
    }
}
