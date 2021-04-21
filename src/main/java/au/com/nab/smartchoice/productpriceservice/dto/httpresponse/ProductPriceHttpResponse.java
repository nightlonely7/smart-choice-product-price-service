package au.com.nab.smartchoice.productpriceservice.dto.httpresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceHttpResponse {

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("partner")
    private String partner;

    @JsonProperty("price")
    private Long price;

    @JsonProperty("base_price")
    private Long basePrice;

    @JsonProperty("promotion")
    private String promotion;

    @JsonProperty("location")
    private String location;

    @JsonProperty("synced_at")
    private LocalDateTime syncedAt;
}
