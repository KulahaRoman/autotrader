package autotrader.binance;

import autotrader.binance.handler.BinanceCandleHandler;
import autotrader.binance.provider.*;
import autotrader.binance.source.BinanceCandleSource;
import autotrader.binance.source.BinanceUpdateSource;
import autotrader.binance.strategy.RiseFallStrategy;
import autotrader.core.BaseScalper;
import autotrader.core.Scalper;
import autotrader.core.ScalperFactory;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Component
public class BinanceScalperFactory implements ScalperFactory {
    private final Properties configuration;

    public BinanceScalperFactory(@Qualifier("binanceProperties") Properties configuration) {
        this.configuration = configuration;
    }

    @Override
    public Scalper createScalper(Properties properties) throws Exception {
        // clients
        var apiKey = Objects.requireNonNull(configuration.getProperty("apiKey"));
        var apiSecret = Objects.requireNonNull(configuration.getProperty("secretKey"));
        var baseURL = Objects.requireNonNull(configuration.getProperty("baseURL"));

        var candlesStreamClient = new WebSocketStreamClientImpl();
        var orderStreamClient = new WebSocketStreamClientImpl();
        var accountStreamClient = new WebSocketStreamClientImpl();

        var spotClient = new SpotClientImpl(apiKey, apiSecret, baseURL);

        // providers
        var exchangeProvider = new BinanceExchangeProvider(spotClient);
        var historyProvider = new BinanceHistoryProvider(spotClient, properties);
        var accountProvider = new BinanceAccountProvider(spotClient);

        var traderStateProvider = new BinanceTraderStateProvider(accountProvider);
        var scalperStateProvider = new BinanceScalperStateProvider(exchangeProvider);

        // check defined scalper properties
        var exchange = exchangeProvider.getExchange();
        var quotation = Objects.requireNonNull(properties.getProperty("symbol"));

        // check if symbol exists
        var symbol = exchange.getSymbols().stream()
                .filter(s -> s.getName().equalsIgnoreCase(quotation))
                .findFirst().orElseThrow(() -> new RuntimeException("Required symbol doesn't exist."));

        // check if spot trading is allowed
        if (!symbol.isSpotTradingAllowed()) {
            throw new RuntimeException("Required trading type is not allowed.");
        }

        // check if all required order types allowed
        if (!symbol.getOrderTypes().containsAll(List.of("MARKET", "STOP_LOSS"))) {
            throw new RuntimeException("Required order types not allowed.");
        }

        // load states
        var traderState = traderStateProvider.getTraderState(properties);
        var scalperState = scalperStateProvider.getScalperState(properties);

        // create sources
        var candleSource = new BinanceCandleSource(candlesStreamClient, properties);
        var updateSource = new BinanceUpdateSource(accountStreamClient, spotClient);

        // create candle handler
        var strategy = new RiseFallStrategy(historyProvider);
        var market = new BinanceMarket(spotClient);
        var trader = new BinanceTrader(updateSource, market, scalperState, traderState);
        var candleHandler = new BinanceCandleHandler(strategy, trader);

        return new BaseScalper<>(candleSource, candleHandler);
    }
}
