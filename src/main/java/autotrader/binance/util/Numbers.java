package autotrader.binance.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Numbers {
    public static double round(double value, double step, RoundingMode mode) {
        var quantity = BigDecimal.valueOf(value);
        var stepSize = BigDecimal.valueOf(step);

        return quantity
                .divide(stepSize, 0, mode)
                .multiply(stepSize).doubleValue();
    }
}
