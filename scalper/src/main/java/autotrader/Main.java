package autotrader;

import autotrader.configuration.Beans;
import autotrader.core.ScalperFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Properties;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Beans.class);
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
