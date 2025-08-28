package autotrader.binance.bar;

import org.ta4j.core.Bar;

public interface CloseableBar extends Bar {
    boolean isClosed();
}
