package au.com.nab.smartchoice.productpriceservice.dto.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
public class ProductPriceCacheEntity {

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
    private String syncedAt;

}
