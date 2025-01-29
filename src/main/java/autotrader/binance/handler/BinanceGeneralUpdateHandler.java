package autotrader.binance.handler;

import autotrader.binance.TraderState;
import autotrader.binance.model.update.AccountUpdate;
import autotrader.binance.model.update.BalanceUpdate;
import autotrader.binance.model.update.Update;
import autotrader.core.UpdateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinanceGeneralUpdateHandler implements UpdateHandler<Update> {
    private final TraderState traderState;

    public BinanceGeneralUpdateHandler(TraderState traderState) {
        this.traderState = traderState;
    }

    @Override
    public void handleUpdate(Update update) {
        switch (update.getType()) {
            case ACCOUNT -> handleUpdate((AccountUpdate) update);
            case BALANCE -> handleUpdate((BalanceUpdate) update);
        }
    }

    private void handleUpdate(BalanceUpdate update) {

    }

    private void handleUpdate(AccountUpdate update) {
        // Update base asset balance if changed
        update.getBalances().forEach(balance -> {
            if (balance.getAsset().equals(traderState.getBaseAssetBalance().getAsset())) {
                traderState.setBaseAssetBalance(balance);
                log.info("Base asset {} balance updated: {}", balance.getAsset(), balance.getFree());
            }
        });

        // Update quote asset balance if changed
        update.getBalances().forEach(balance -> {
            if (balance.getAsset().equals(traderState.getQuoteAssetBalance().getAsset())) {
                traderState.setQuoteAssetBalance(balance);
                log.info("Quote asset {} balance updated: {}", balance.getAsset(), balance.getFree());
            }
        });
    }
}
