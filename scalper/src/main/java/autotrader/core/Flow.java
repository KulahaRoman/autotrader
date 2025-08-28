package autotrader.core;

// Finite-state machine
public interface Flow<S extends Enum<S>, E extends Enum<E>> {
    S nextState(E event);
}
