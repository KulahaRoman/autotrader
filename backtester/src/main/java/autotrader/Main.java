package autotrader;

import autotrader.configuration.Beans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Beans.class);

        var properties = new Properties();
        properties.setProperty("symbol", "BTCUSDT");
        properties.setProperty("period", "1m");

        var startTime = LocalDateTime.of(2025, 1, 1, 0, 0);
        var startMili = startTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();

        var endTime = LocalDateTime.of(2025, 1, 7, 0, 0);
        var endMili = endTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();

        var diffMili = endMili - startMili;
        var diffMins = diffMili / 1000 / 60;

        var
    }
}
