package autotrader.binance;

import autotrader.binance.model.Update;
import autotrader.binance.model.update.AccountUpdate;
import autotrader.binance.model.update.BalanceUpdate;
import autotrader.binance.model.update.OrderUpdate;
import autotrader.core.UpdateHandler;

public class BinanceUpdateHandler implements UpdateHandler<Update> {
    private final TraderState traderState;

    public BinanceUpdateHandler(TraderState traderState) {
        this.traderState = traderState;
    }

    @Override
    public void handleUpdate(Update update) throws Exception {
        switch (update.getType()) {
            case ACCOUNT -> handleUpdate((AccountUpdate) update);
            case BALANCE -> handleUpdate((BalanceUpdate) update);
            case ORDER -> handleUpdate((OrderUpdate) update);
        }
    }

    private void handleUpdate(OrderUpdate update) {

    }

    private void handleUpdate(BalanceUpdate update) {

    }

    private void handleUpdate(AccountUpdate update) {

    }
}
