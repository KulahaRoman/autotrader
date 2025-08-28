package autotrader.binance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Balance {
    private String asset;
    private double free;
    private double locked;
}