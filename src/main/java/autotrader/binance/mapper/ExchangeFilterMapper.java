package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberAlgoOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberIcebergOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.ExchangeMaxNumberOrdersFilterDTO;
import autotrader.binance.dto.exchange.filter.FilterDTO;
import autotrader.binance.model.exchange.filter.ExchangeMaxNumberAlgoOrdersFilter;
import autotrader.binance.model.exchange.filter.ExchangeMaxNumberIcebergOrdersFilter;
import autotrader.binance.model.exchange.filter.ExchangeMaxNumberOrdersFilter;
import autotrader.binance.model.exchange.filter.Filter;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface ExchangeFilterMapper {
    ExchangeFilterMapper INSTANCE = Mappers.getMapper(ExchangeFilterMapper.class);

    @SubclassMapping(source = ExchangeMaxNumberAlgoOrdersFilter.class,
            target = ExchangeMaxNumberAlgoOrdersFilterDTO.class)
    @SubclassMapping(source = ExchangeMaxNumberOrdersFilter.class,
            target = ExchangeMaxNumberOrdersFilterDTO.class)
    @SubclassMapping(source = ExchangeMaxNumberIcebergOrdersFilter.class,
            target = ExchangeMaxNumberIcebergOrdersFilterDTO.class)
    FilterDTO toDTO(Filter filter);

    @SubclassMapping(source = ExchangeMaxNumberAlgoOrdersFilterDTO.class,
            target = ExchangeMaxNumberAlgoOrdersFilter.class)
    @SubclassMapping(source = ExchangeMaxNumberOrdersFilterDTO.class,
            target = ExchangeMaxNumberOrdersFilter.class)
    @SubclassMapping(source = ExchangeMaxNumberIcebergOrdersFilterDTO.class,
            target = ExchangeMaxNumberIcebergOrdersFilter.class)
    Filter toModel(FilterDTO dto);
}
