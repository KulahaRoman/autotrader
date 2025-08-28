package autotrader.binance.mapper;

import autotrader.binance.dto.candle.CandleStickDTO;
import autotrader.binance.dto.candle.CandleStickEventDTO;
import autotrader.binance.model.candle.CandleStick;
import autotrader.binance.model.candle.CandleStickEvent;

public class CandleStickEventMapper {
    public static CandleStickEventDTO toDTO(CandleStickEvent candleStickEvent) {
        var candleStickEventDTO = new CandleStickEventDTO();
        candleStickEventDTO.setEventType(candleStickEvent.getEventType());
        candleStickEventDTO.setEventTime(candleStickEvent.getEventTime());
        candleStickEventDTO.setSymbol(candleStickEvent.getSymbol());
        candleStickEventDTO.setCandleStickDTO(toDTO(candleStickEvent.getCandleStick()));

        return candleStickEventDTO;
    }

    public static CandleStickEvent toModel(CandleStickEventDTO candleStickEventDTO) {
        var candleStickEvent = new CandleStickEvent();
        candleStickEvent.setEventType(candleStickEventDTO.getEventType());
        candleStickEvent.setEventTime(candleStickEventDTO.getEventTime());
        candleStickEvent.setSymbol(candleStickEventDTO.getSymbol());
        candleStickEvent.setCandleStick(toModel(candleStickEventDTO.getCandleStickDTO()));

        return candleStickEvent;
    }

    private static CandleStickDTO toDTO(CandleStick candleStick) {
        var candleStickDTO = new CandleStickDTO();
        candleStickDTO.setOpenTime(candleStick.getOpenTime());
        candleStickDTO.setCloseTime(candleStick.getCloseTime());
        candleStickDTO.setSymbol(candleStick.getSymbol());
        candleStickDTO.setInterval(candleStick.getInterval());
        candleStickDTO.setFirstTradeID(candleStick.getFirstTradeID());
        candleStickDTO.setLastTradeID(candleStick.getLastTradeID());
        candleStickDTO.setOpenPrice(candleStick.getOpenPrice());
        candleStickDTO.setClosePrice(candleStick.getClosePrice());
        candleStickDTO.setHighPrice(candleStick.getHighPrice());
        candleStickDTO.setLowPrice(candleStick.getLowPrice());
        candleStickDTO.setVolume(candleStick.getVolume());
        candleStickDTO.setTrades(candleStick.getTrades());
        candleStickDTO.setClosed(candleStick.isClosed());
        candleStickDTO.setQuoteAssetVolume(candleStick.getQuoteAssetVolume());
        candleStickDTO.setTakerBaseAssetVolume(candleStick.getTakerBaseAssetVolume());
        candleStickDTO.setTakerQuoteAssetVolume(candleStick.getTakerQuoteAssetVolume());

        return candleStickDTO;
    }

    private static CandleStick toModel(CandleStickDTO candleStickDTO) {
        var candleStick = new CandleStick();
        candleStick.setOpenTime(candleStickDTO.getOpenTime());
        candleStick.setCloseTime(candleStickDTO.getCloseTime());
        candleStick.setSymbol(candleStickDTO.getSymbol());
        candleStick.setInterval(candleStickDTO.getInterval());
        candleStick.setFirstTradeID(candleStickDTO.getFirstTradeID());
        candleStick.setLastTradeID(candleStickDTO.getLastTradeID());
        candleStick.setOpenPrice(candleStickDTO.getOpenPrice());
        candleStick.setClosePrice(candleStickDTO.getClosePrice());
        candleStick.setHighPrice(candleStickDTO.getHighPrice());
        candleStick.setLowPrice(candleStickDTO.getLowPrice());
        candleStick.setVolume(candleStickDTO.getVolume());
        candleStick.setTrades(candleStickDTO.getTrades());
        candleStick.setClosed(candleStickDTO.isClosed());
        candleStick.setQuoteAssetVolume(candleStickDTO.getQuoteAssetVolume());
        candleStick.setTakerBaseAssetVolume(candleStickDTO.getTakerBaseAssetVolume());
        candleStick.setTakerQuoteAssetVolume(candleStickDTO.getTakerQuoteAssetVolume());

        return candleStick;
    }
}
