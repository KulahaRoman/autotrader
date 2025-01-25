package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.ExchangeDTO;
import autotrader.binance.dto.exchange.RateLimitDTO;
import autotrader.binance.dto.exchange.SORDTO;
import autotrader.binance.dto.exchange.symbol.SymbolDTO;
import autotrader.binance.model.exchange.Exchange;
import autotrader.binance.model.exchange.RateLimit;
import autotrader.binance.model.exchange.SOR;
import autotrader.binance.model.exchange.symbol.Symbol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ExchangeFilterMapper.class, SymbolFilterMapper.class})
public interface ExchangeMapper {
    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    ExchangeDTO toDTO(Exchange exchange);

    Exchange toModel(ExchangeDTO exchangeDTO);

    RateLimitDTO toDTO(RateLimit rateLimit);

    RateLimit toModel(RateLimitDTO rateLimitDTO);

    SymbolDTO toDTO(Symbol symbol);

    Symbol toModel(SymbolDTO symbolDTO);

    SORDTO toDTO(SOR sor);

    SOR toModel(SORDTO sorDTO);
}
