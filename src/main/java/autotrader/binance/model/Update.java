package autotrader.binance.model;

import autotrader.binance.model.update.UpdateType;

public interface Update {
    UpdateType getType();

    long getTime();
}
