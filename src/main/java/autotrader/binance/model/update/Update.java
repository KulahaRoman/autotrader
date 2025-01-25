package autotrader.binance.model.update;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Update {
    private final UpdateType updateType;
    private final long updateTime;
}
