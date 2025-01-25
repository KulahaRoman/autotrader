package autotrader.binance.model.exchange;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SOR {
    private String baseAsset;
    private List<String> symbols;
}
