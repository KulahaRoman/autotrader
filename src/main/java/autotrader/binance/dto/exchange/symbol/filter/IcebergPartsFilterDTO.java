package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class IcebergPartsFilterDTO extends FilterDTO {
    private final int limit;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public IcebergPartsFilterDTO(@JsonProperty("limit") int limit) {
        super("ICEBERG_PARTS");
        this.limit = limit;
    }
}
