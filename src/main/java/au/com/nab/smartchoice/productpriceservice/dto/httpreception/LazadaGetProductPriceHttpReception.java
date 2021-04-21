package au.com.nab.smartchoice.productpriceservice.dto.httpreception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LazadaGetProductPriceHttpReception {

    @JsonProperty("itemId")
    private String itemId;

    @JsonProperty("price")
    private Long price;

    @JsonProperty("originalPrice")
    private Long originalPrice;

    @JsonProperty("promotion")
    private String promotion;

    @JsonProperty("location")
    private String location;
}
