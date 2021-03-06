package au.com.nab.smartchoice.productpriceservice.dto.httpreception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TikiGetProductPriceHttpReception {

    @JsonProperty("product_type_id")
    private String productTypeId;

    @JsonProperty("current_price")
    private Long currentPrice;

    @JsonProperty("market_price")
    private Long marketPrice;

    @JsonProperty("promotion")
    private String promotion;

    @JsonProperty("location")
    private String location;

}
