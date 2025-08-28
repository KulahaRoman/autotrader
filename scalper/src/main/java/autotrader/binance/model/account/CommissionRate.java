package autotrader.binance.model.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommissionRate {
    private double maker;
    private double taker;
    private double buyer;
    private double seller;
}