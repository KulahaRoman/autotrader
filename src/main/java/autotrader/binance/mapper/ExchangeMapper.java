package autotrader.binance.mapper;

import autotrader.binance.dto.exchange.ExchangeDTO;
import autotrader.binance.dto.exchange.RateLimitDTO;
import autotrader.binance.dto.exchange.SORDTO;
import autotrader.binance.dto.exchange.symbol.SymbolDTO;
import autotrader.binance.model.exchange.Exchange;
import autotrader.binance.model.exchange.RateLimit;
import autotrader.binance.model.exchange.SOR;
import autotrader.binance.model.exchange.symbol.Symbol;

public class ExchangeMapper {
    public static ExchangeDTO toDTO(Exchange exchange) {
        var exchangeDTO = new ExchangeDTO();
        exchangeDTO.setServerTime(exchange.getServerTime());
        exchangeDTO.setTimezone(exchange.getTimezone());
        if (exchange.getExchangeFilters() != null) {
            exchangeDTO.setExchangeFilters(exchange.getExchangeFilters()
                    .stream().map(ExchangeFilterMapper::toDTO).toList());
        }
        if (exchange.getSymbols() != null) {
            exchangeDTO.setSymbols(exchange.getSymbols()
                    .stream().map(ExchangeMapper::toDTO).toList());
        }
        if (exchange.getRateLimits() != null) {
            exchangeDTO.setRateLimits(exchange.getRateLimits()
                    .stream().map(ExchangeMapper::toDTO).toList());
        }
        if (exchange.getSors() != null) {
            exchangeDTO.setSors(exchange.getSors()
                    .stream().map(ExchangeMapper::toDTO).toList());
        }

        return exchangeDTO;
    }

    public static Exchange toModel(ExchangeDTO exchangeDTO) {
        var exchange = new Exchange();
        exchange.setServerTime(exchangeDTO.getServerTime());
        exchange.setTimezone(exchangeDTO.getTimezone());
        if (exchangeDTO.getExchangeFilters() != null) {
            exchange.setExchangeFilters(exchangeDTO.getExchangeFilters()
                    .stream().map(ExchangeFilterMapper::toModel).toList());
        }
        if (exchangeDTO.getRateLimits() != null) {
            exchange.setRateLimits(exchangeDTO.getRateLimits()
                    .stream().map(ExchangeMapper::toModel).toList());
        }
        if (exchangeDTO.getSymbols() != null) {
            exchange.setSymbols(exchangeDTO.getSymbols()
                    .stream().map(ExchangeMapper::toModel).toList());
        }
        if (exchangeDTO.getSors() != null) {
            exchange.setSors(exchangeDTO.getSors()
                    .stream().map(ExchangeMapper::toModel).toList());
        }

        return exchange;
    }

    private static RateLimitDTO toDTO(RateLimit rateLimit) {
        var rateLimitDTO = new RateLimitDTO();
        rateLimitDTO.setRateLimitType(rateLimit.getRateLimitType());
        rateLimitDTO.setLimit(rateLimit.getLimit());
        rateLimitDTO.setInterval(rateLimit.getInterval());
        rateLimitDTO.setIntervalNumber(rateLimit.getIntervalNumber());

        return rateLimitDTO;
    }

    private static RateLimit toModel(RateLimitDTO rateLimitDTO) {
        var rateLimit = new RateLimit();
        rateLimit.setRateLimitType(rateLimitDTO.getRateLimitType());
        rateLimit.setLimit(rateLimitDTO.getLimit());
        rateLimit.setInterval(rateLimitDTO.getInterval());
        rateLimit.setIntervalNumber(rateLimitDTO.getIntervalNumber());

        return rateLimit;
    }

    private static SymbolDTO toDTO(Symbol symbol) {
        var symbolDTO = new SymbolDTO();
        symbolDTO.setName(symbol.getName());
        symbolDTO.setStatus(symbol.getStatus());
        symbolDTO.setBaseAsset(symbol.getBaseAsset());
        symbolDTO.setQuoteAsset(symbol.getQuoteAsset());
        symbolDTO.setBaseAssetPrecision(symbol.getBaseAssetPrecision());
        symbolDTO.setQuoteAssetPrecision(symbol.getQuoteAssetPrecision());
        symbolDTO.setBaseCommissionPrecision(symbol.getBaseCommissionPrecision());
        symbolDTO.setQuoteCommissionPrecision(symbol.getQuoteCommissionPrecision());
        if (symbol.getFilters() != null) {
            symbolDTO.setFilterDTOS(symbol.getFilters()
                    .stream().map(SymbolFilterMapper::toDTO).toList());
        }
        symbolDTO.setPermissions(symbol.getPermissions());
        symbolDTO.setAllowTrailingStop(symbol.isAllowTrailingStop());
        symbolDTO.setAllowedSelfTradePreventionModes(symbol.getAllowedSelfTradePreventionModes());
        symbolDTO.setCancelReplaceAllowed(symbol.isCancelReplaceAllowed());
        symbolDTO.setIcebergAllowed(symbol.isIcebergAllowed());
        symbolDTO.setOcoAllowed(symbol.isOcoAllowed());
        symbolDTO.setOtoAllowed(symbol.isOtoAllowed());
        symbolDTO.setOrderTypes(symbol.getOrderTypes());
        symbolDTO.setPermissionSets(symbol.getPermissionSets());
        symbolDTO.setSpotTradingAllowed(symbol.isSpotTradingAllowed());
        symbolDTO.setMarginTradingAllowed(symbol.isMarginTradingAllowed());
        symbolDTO.setQuoteOrderQuantityMarketAllowed(symbol.isQuoteOrderQuantityMarketAllowed());

        return symbolDTO;
    }

    private static Symbol toModel(SymbolDTO symbolDTO) {
        var symbol = new Symbol();
        symbol.setName(symbolDTO.getName());
        symbol.setStatus(symbolDTO.getStatus());
        symbol.setBaseAsset(symbolDTO.getBaseAsset());
        symbol.setQuoteAsset(symbolDTO.getQuoteAsset());
        symbol.setBaseAssetPrecision(symbolDTO.getBaseAssetPrecision());
        symbol.setQuoteAssetPrecision(symbolDTO.getQuoteAssetPrecision());
        symbol.setBaseCommissionPrecision(symbolDTO.getBaseCommissionPrecision());
        symbol.setQuoteCommissionPrecision(symbolDTO.getQuoteCommissionPrecision());
        if (symbolDTO.getFilterDTOS() != null) {
            symbol.setFilters(symbolDTO.getFilterDTOS()
                    .stream().map(SymbolFilterMapper::toModel).toList());
        }
        symbol.setPermissions(symbolDTO.getPermissions());
        symbol.setAllowTrailingStop(symbolDTO.isAllowTrailingStop());
        symbol.setAllowedSelfTradePreventionModes(symbolDTO.getAllowedSelfTradePreventionModes());
        symbol.setCancelReplaceAllowed(symbolDTO.isCancelReplaceAllowed());
        symbol.setIcebergAllowed(symbolDTO.isIcebergAllowed());
        symbol.setOcoAllowed(symbolDTO.isOcoAllowed());
        symbol.setOtoAllowed(symbolDTO.isOtoAllowed());
        symbol.setOrderTypes(symbolDTO.getOrderTypes());
        symbol.setPermissionSets(symbolDTO.getPermissionSets());
        symbol.setSpotTradingAllowed(symbolDTO.isSpotTradingAllowed());
        symbol.setMarginTradingAllowed(symbolDTO.isMarginTradingAllowed());
        symbol.setQuoteOrderQuantityMarketAllowed(symbolDTO.isQuoteOrderQuantityMarketAllowed());

        return symbol;
    }

    private static SORDTO toDTO(SOR sor) {
        var sorDTO = new SORDTO();
        sorDTO.setBaseAsset(sor.getBaseAsset());
        sorDTO.setSymbols(sor.getSymbols());

        return sorDTO;
    }

    private static SOR toModel(SORDTO sorDTO) {
        var sor = new SOR();
        sor.setBaseAsset(sorDTO.getBaseAsset());
        sor.setSymbols(sorDTO.getSymbols());

        return sor;
    }
}
