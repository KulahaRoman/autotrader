package autotrader.binance;

import autotrader.binance.strategy.RiseFallStrategy;
import autotrader.core.BaseUpdatableScalper;
import autotrader.core.Scalper;
import autotrader.core.ScalperFactory;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketStreamClient;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class BinanceScalperFactory implements ScalperFactory {
    private final WebSocketStreamClient wsStreamClient;
    private final SpotClient spotClient;

    public BinanceScalperFactory(WebSocketStreamClient wsStreamClient,
                                 SpotClient spotClient) {
        this.wsStreamClient = wsStreamClient;
        this.spotClient = spotClient;
    }

    @Override
    public Scalper createScalper(Properties properties) throws Exception {
        // providers
        var exchangeProvider = new BinanceExchangeProvider(spotClient);
        var historyProvider = new BinanceHistoryProvider(spotClient, properties);
        var accountProvider = new BinanceAccountProvider(spotClient);

        var traderStateProvider = new BinanceTraderStateProvider(accountProvider);
        var scalperStateProvider = new BinanceScalperStateProvider(exchangeProvider);

        // load states
        var traderState = traderStateProvider.getTraderState(properties);
        var scalperState = scalperStateProvider.getScalperState(properties);

        // create candle source
        var candleSource = new BinanceCandleSource(wsStreamClient, properties);

        // create candle handler
        var strategy = new RiseFallStrategy(historyProvider);
        var market = new BinanceMarket(spotClient);
        var trader = new BinanceTrader(market, scalperState, traderState);
        var candleHandler = new BinanceCandleHandler(strategy, trader);

        // create update source
        var updateSource = new BinanceUpdateSource(wsStreamClient, spotClient);

        // create update handler
        var updateHandler = new BinanceUpdateHandler(traderState);

        return new BaseUpdatableScalper<>(candleSource, candleHandler, updateSource, updateHandler);
    }
}
