package autotrader.binance.model.exchange.symbol;

import autotrader.binance.model.exchange.symbol.filter.Filter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Symbol {
    private String name;
    private String status;
    private String baseAsset;
    private int baseAssetPrecision;
    private String quoteAsset;
    private int quotePrecision;
    private int quoteAssetPrecision;
    private int baseCommissionPrecision;
    private int quoteCommissionPrecision;
    private List<String> orderTypes;
    private boolean icebergAllowed;
    private boolean ocoAllowed;
    private boolean otoAllowed;
    private boolean quoteOrderQuantityMarketAllowed;
    private boolean allowTrailingStop;
    private boolean cancelReplaceAllowed;
    private boolean isSpotTradingAllowed;
    private boolean isMarginTradingAllowed;
    private List<Filter> filters;
    private List<Object> permissions;
    private List<Set<String>> permissionSets;
    private String defaultSelfTradePreventionMode;
    private List<String> allowedSelfTradePreventionModes;
}
