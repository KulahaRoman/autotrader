package autotrader.binance.mapper;

import autotrader.binance.dto.candle.CandleStickDTO;
import autotrader.binance.dto.candle.CandleStickEventDTO;
import autotrader.binance.model.candle.CandleStick;
import autotrader.binance.model.candle.CandleStickEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandleStickEventMapper {
    CandleStickEventMapper INSTANCE = Mappers.getMapper(CandleStickEventMapper.class);
    
    CandleStickEventDTO toDTO(CandleStickEvent candleStickEvent);

    CandleStickEvent toModel(CandleStickEventDTO candleStickEventDTO);

    CandleStickDTO toDTO(CandleStick candleStick);

    CandleStick toModel(CandleStickDTO candleStickDTO);
}
