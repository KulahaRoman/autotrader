package autotrader;

import autotrader.core.ScalperFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@Slf4j
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();
        var factory = context.getBean(ScalperFactory.class);

        var properties = new Properties();
        properties.setProperty("symbol", "BTCUSDT");
        properties.setProperty("period", "1m");

        try (var scalper = factory.createScalper(properties)) {
            scalper.run();
        } catch (Exception e) {
            log.error("Critical error occurred", e);
        }
    }
}
