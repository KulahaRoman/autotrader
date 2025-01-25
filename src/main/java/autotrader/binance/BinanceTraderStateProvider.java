package autotrader.binance;

import java.util.Properties;

public class BinanceTraderStateProvider implements TraderStateProvider {
    private final AccountProvider accountProvider;

    public BinanceTraderStateProvider(AccountProvider accountProvider) {
        this.accountProvider = accountProvider;
    }

    @Override
    public TraderState getTraderState(Properties properties) throws Exception {
        var symbol = properties.getProperty("symbol");
        var quoteAsset = symbol.substring(0, symbol.length() / 2);
        var baseAsset = symbol.substring(symbol.length() / 2);

        var account = accountProvider.getAccount();
        
        var quoteBalance = account.getBalances()
                .stream()
                .filter(balance -> balance.getAsset().equals(quoteAsset))
                .findFirst().orElse(null);
        var baseBalance = account.getBalances()
                .stream()
                .filter(balance -> balance.getAsset().equals(baseAsset))
                .findFirst().orElse(null);

        var state = new TraderState();
        state.setQuoteAssetBalance(quoteBalance);
        state.setBaseAssetBalance(baseBalance);

        return state;
    }
}
