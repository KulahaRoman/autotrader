package autotrader.binance.model.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Update {
    private UpdateType type;
    private long time;
}
