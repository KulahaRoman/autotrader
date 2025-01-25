package autotrader.binance.dto.exchange.symbol;

import autotrader.binance.dto.exchange.symbol.filter.FilterDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class SymbolDTO {
    @JsonProperty("symbol")
    private final String name;
    @JsonProperty("status")
    private final String status;
    @JsonProperty("baseAsset")
    private final String baseAsset;
    @JsonProperty("baseAssetPrecision")
    private final int baseAssetPrecision;
    @JsonProperty("quoteAsset")
    private final String quoteAsset;
    @JsonProperty("quotePrecision")
    private final int quotePrecision;
    @JsonProperty("quoteAssetPrecision")
    private final int quoteAssetPrecision;
    @JsonProperty("baseCommissionPrecision")
    private final int baseCommissionPrecision;
    @JsonProperty("quoteCommissionPrecision")
    private final int quoteCommissionPrecision;
    @JsonProperty("orderTypes")
    private final List<String> orderTypes;
    @JsonProperty("icebergAllowed")
    private final boolean icebergAllowed;
    @JsonProperty("ocoAllowed")
    private final boolean ocoAllowed;
    @JsonProperty("otoAllowed")
    private final boolean otoAllowed;
    @JsonProperty("quoteOrderQtyMarketAllowed")
    private final boolean quoteOrderQuantityMarketAllowed;
    @JsonProperty("allowTrailingStop")
    private final boolean allowTrailingStop;
    @JsonProperty("cancelReplaceAllowed")
    private final boolean cancelReplaceAllowed;
    @JsonProperty("isSpotTradingAllowed")
    private final boolean isSpotTradingAllowed;
    @JsonProperty("isMarginTradingAllowed")
    private final boolean isMarginTradingAllowed;
    @JsonProperty("filters")
    private final List<FilterDTO> filterDTOS;
    @JsonProperty("permissions")
    private final List<Object> permissions;
    @JsonProperty("permissionSets")
    private final List<Set<String>> permissionSets;
    @JsonProperty("defaultSelfTradePreventionMode")
    private final String defaultSelfTradePreventionMode;
    @JsonProperty("allowedSelfTradePreventionModes")
    private final List<String> allowedSelfTradePreventionModes;

    public List<String> getOrderTypes() {
        return Collections.unmodifiableList(orderTypes);
    }

    public List<FilterDTO> getFilterDTOS() {
        return Collections.unmodifiableList(filterDTOS);
    }

    public List<Object> getPermissions() {
        return Collections.unmodifiableList(permissions);
    }

    public List<Set<String>> getPermissionSets() {
        return Collections.unmodifiableList(permissionSets);
    }

    public List<String> getAllowedSelfTradePreventionModes() {
        return Collections.unmodifiableList(allowedSelfTradePreventionModes);
    }
}
