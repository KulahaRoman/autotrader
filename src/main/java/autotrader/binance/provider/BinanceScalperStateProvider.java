package autotrader.binance.provider;

import autotrader.binance.ScalperState;

import java.util.Properties;

public class BinanceScalperStateProvider implements ScalperStateProvider {
    private final ExchangeProvider exchangeProvider;

    public BinanceScalperStateProvider(ExchangeProvider exchangeProvider) {
        this.exchangeProvider = exchangeProvider;
    }

    @Override
    public ScalperState getScalperState(Properties properties) throws Exception {
        var exchange = exchangeProvider.getExchange();
        var symbolName = properties.getProperty("symbol");
        var symbolData = exchange.getSymbols()
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(symbolName))
                .findFirst().orElse(null);

        var state = new ScalperState();
        state.setSymbol(symbolData);

        return state;
    }
}
