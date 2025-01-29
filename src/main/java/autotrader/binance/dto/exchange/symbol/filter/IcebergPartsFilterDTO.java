package autotrader.binance.dto.exchange.symbol.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IcebergPartsFilterDTO extends FilterDTO {
    private int limit;

    public IcebergPartsFilterDTO() {
        super("ICEBERG_PARTS");
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public IcebergPartsFilterDTO(@JsonProperty("limit") int limit) {
        super("ICEBERG_PARTS");
        this.limit = limit;
    }
}
