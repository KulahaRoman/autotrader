package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.symbol.filter.*;
import autotrader.binance.model.exchange.symbol.filter.*;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface SymbolFilterMapper {
    SymbolFilterMapper INSTANCE = Mappers.getMapper(SymbolFilterMapper.class);

    @SubclassMapping(source = IcebergPartsFilter.class, target = IcebergPartsFilterDTO.class)
    @SubclassMapping(source = LotSizeFilter.class, target = LotSizeFilterDTO.class)
    @SubclassMapping(source = MarketLotSizeFilter.class, target = MarketLotSizeFilterDTO.class)
    @SubclassMapping(source = MaxNumberAlgoOrdersFilter.class, target = MaxNumberAlgoOrdersFilterDTO.class)
    @SubclassMapping(source = MaxNumberIcebergOrdersFilter.class, target = MaxNumberIcebergOrdersFilterDTO.class)
    @SubclassMapping(source = MaxNumberOrdersFilter.class, target = MaxNumberOrdersFilterDTO.class)
    @SubclassMapping(source = MaxPositionFilter.class, target = MaxPositionFilterDTO.class)
    @SubclassMapping(source = MinimalNotionalFilter.class, target = MinimalNotionalFilterDTO.class)
    @SubclassMapping(source = NotionalFilter.class, target = NotionalFilterDTO.class)
    @SubclassMapping(source = PercentPriceBySideFilter.class, target = PercentPriceBySideFilterDTO.class)
    @SubclassMapping(source = PercentPriceFilter.class, target = PercentPriceFilterDTO.class)
    @SubclassMapping(source = PriceFilter.class, target = PriceFilterDTO.class)
    @SubclassMapping(source = TrailingDeltaFilter.class, target = TrailingDeltaFilterDTO.class)
    FilterDTO toDTO(Filter filter);

    @SubclassMapping(source = IcebergPartsFilterDTO.class, target = IcebergPartsFilter.class)
    @SubclassMapping(source = LotSizeFilterDTO.class, target = LotSizeFilter.class)
    @SubclassMapping(source = MarketLotSizeFilterDTO.class, target = MarketLotSizeFilter.class)
    @SubclassMapping(source = MaxNumberAlgoOrdersFilterDTO.class, target = MaxNumberAlgoOrdersFilter.class)
    @SubclassMapping(source = MaxNumberIcebergOrdersFilterDTO.class, target = MaxNumberIcebergOrdersFilter.class)
    @SubclassMapping(source = MaxNumberOrdersFilterDTO.class, target = MaxNumberOrdersFilter.class)
    @SubclassMapping(source = MaxPositionFilterDTO.class, target = MaxPositionFilter.class)
    @SubclassMapping(source = MinimalNotionalFilterDTO.class, target = MinimalNotionalFilter.class)
    @SubclassMapping(source = NotionalFilterDTO.class, target = NotionalFilter.class)
    @SubclassMapping(source = PercentPriceBySideFilterDTO.class, target = PercentPriceBySideFilter.class)
    @SubclassMapping(source = PercentPriceFilterDTO.class, target = PercentPriceFilter.class)
    @SubclassMapping(source = PriceFilterDTO.class, target = PriceFilter.class)
    @SubclassMapping(source = TrailingDeltaFilterDTO.class, target = TrailingDeltaFilter.class)
    Filter toModel(FilterDTO dto);
}
