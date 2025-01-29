package autotrader.binance.flow;

import autotrader.core.Flow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TradeFlow implements Flow<State, Event> {
    private State currentState = State.INITIAL;

    @Override
    public State nextState(Event event) {
        switch (currentState) {
            case INITIAL -> {
                if (event == Event.BUY_FILLED) {
                    currentState = State.BOUGHT;
                }
                if (event == Event.REJECTED || event == Event.ERROR) {
                    currentState = State.FAILED;
                }
                if (event == Event.CANCELED) {
                    currentState = State.CANCELED;
                }
            }
            case BOUGHT -> {
                if (event == Event.STOP_LOSS_FILLED) {
                    currentState = State.SOLD;
                }
                if (event == Event.SELL_FILLED) {
                    currentState = State.SOLD;
                }
                if (event == Event.REJECTED || event == Event.ERROR) {
                    currentState = State.FAILED;
                }
                if (event == Event.CANCELED) {
                    currentState = State.CANCELED;
                }
            }
            case SOLD -> {
                currentState = State.COMPLETED;
            }
            default -> throw new IllegalStateException("Invalid state: " + currentState);
        }

        return currentState;
    }
}
