package autotrader.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Properties;

@Configuration
@ComponentScan("autotrader")
@PropertySources({
        @PropertySource("classpath:client.properties"),
        @PropertySource("classpath:application.properties")
})
public class Beans {
    @Bean
    public Properties binanceProperties(@Value("${autotrader.client.binance.api_key}") String apiKey,
                                        @Value("${autotrader.client.binance.secret_key}") String secretKey,
                                        @Value("${autotrader.client.binance.base_url}") String baseURL) {
        var properties = new Properties();
        properties.setProperty("apiKey", apiKey);
        properties.setProperty("secretKey", secretKey);
        properties.setProperty("baseURL", baseURL);

        return properties;
    }
}
