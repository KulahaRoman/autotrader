package autotrader.binance.source;

import autotrader.binance.model.update.Update;
import autotrader.binance.model.update.UpdateType;
import autotrader.core.UpdateSource;

public class BinanceOrderUpdateSource implements UpdateSource<Update> {
    private final UpdateSource<Update> commonSource;

    public BinanceOrderUpdateSource(UpdateSource<Update> commonSource) {
        this.commonSource = commonSource;
    }

    @Override
    public Update nextUpdate() {
        while (true) {
            var update = commonSource.nextUpdate();
            if (update.getType().equals(UpdateType.ORDER)) {
                return update;
            }
        }
    }
}
