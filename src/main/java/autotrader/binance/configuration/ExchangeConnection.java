package autotrader.binance.configuration;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.WebSocketApiClient;
import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.WebSocketApiClientImpl;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;
import com.binance.connector.client.utils.signaturegenerator.HmacSignatureGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "autotrader.binance")
@PropertySource("classpath:client.properties")
public class ExchangeConnection {
    @Bean
    public SpotClient spotClient(@Value("${autotrader.client.binance.api_key}") String apiKey,
                                 @Value("${autotrader.client.binance.secret_key}") String secretKey,
                                 @Value("${autotrader.client.binance.base_url}") String baseURL) {
        return new SpotClientImpl(apiKey, secretKey, baseURL);
    }

    @Bean
    public WebSocketStreamClient webSocketStreamClient() {
        return new WebSocketStreamClientImpl();
    }

    @Bean
    public WebSocketApiClient webSocketApiClient(@Value("${autotrader.client.binance.api_key}") String apiKey,
                                                 @Value("${autotrader.client.binance.secret_key}") String secretKey,
                                                 @Value("${autotrader.client.binance.base_url}") String baseURL) {
        var signatureGenerator = new HmacSignatureGenerator(secretKey);
        return new WebSocketApiClientImpl(apiKey, signatureGenerator, baseURL);
    }
}
