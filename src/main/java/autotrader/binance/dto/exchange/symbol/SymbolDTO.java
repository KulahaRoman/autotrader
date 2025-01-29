package autotrader.binance.dto.exchange.symbol;

import autotrader.binance.dto.exchange.symbol.filter.FilterDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolDTO {
    @JsonProperty("symbol")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("baseAssetPrecision")
    private int baseAssetPrecision;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("quotePrecision")
    private int quotePrecision;
    @JsonProperty("quoteAssetPrecision")
    private int quoteAssetPrecision;
    @JsonProperty("baseCommissionPrecision")
    private int baseCommissionPrecision;
    @JsonProperty("quoteCommissionPrecision")
    private int quoteCommissionPrecision;
    @JsonProperty("orderTypes")
    private List<String> orderTypes;
    @JsonProperty("icebergAllowed")
    private boolean icebergAllowed;
    @JsonProperty("ocoAllowed")
    private boolean ocoAllowed;
    @JsonProperty("otoAllowed")
    private boolean otoAllowed;
    @JsonProperty("quoteOrderQtyMarketAllowed")
    private boolean quoteOrderQuantityMarketAllowed;
    @JsonProperty("allowTrailingStop")
    private boolean allowTrailingStop;
    @JsonProperty("cancelReplaceAllowed")
    private boolean cancelReplaceAllowed;
    @JsonProperty("isSpotTradingAllowed")
    private boolean isSpotTradingAllowed;
    @JsonProperty("isMarginTradingAllowed")
    private boolean isMarginTradingAllowed;
    @JsonProperty("filters")
    private List<FilterDTO> filterDTOS;
    @JsonProperty("permissions")
    private List<Object> permissions;
    @JsonProperty("permissionSets")
    private List<Set<String>> permissionSets;
    @JsonProperty("defaultSelfTradePreventionMode")
    private String defaultSelfTradePreventionMode;
    @JsonProperty("allowedSelfTradePreventionModes")
    private List<String> allowedSelfTradePreventionModes;
}
