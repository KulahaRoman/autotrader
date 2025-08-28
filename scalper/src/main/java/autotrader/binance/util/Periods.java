package autotrader.binance.util;

import java.time.Duration;

public class Periods {
    public static Duration toDuration(String period) {
        if (period == null || period.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        var unit = period.substring(period.length() - 1);
        var value = period.substring(0, period.length() - 1);

        long amount;
        try {
            amount = Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid duration value: " + value, e);
        }

        return switch (unit) {
            case "s" -> Duration.ofSeconds(amount);
            case "m" -> Duration.ofMinutes(amount);
            case "h" -> Duration.ofHours(amount);
            case "d" -> Duration.ofDays(amount);
            case "w" -> Duration.ofDays(amount * 7);
            case "M" -> Duration.ofDays(amount * 30);
            default -> throw new IllegalArgumentException("Unknown duration unit: " + unit);
        };
    }
}
