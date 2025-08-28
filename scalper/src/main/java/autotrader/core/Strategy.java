package autotrader.core;

import java.util.Optional;

public interface Strategy<C> {
    Optional<Decision> getDecision(C candle);
}
