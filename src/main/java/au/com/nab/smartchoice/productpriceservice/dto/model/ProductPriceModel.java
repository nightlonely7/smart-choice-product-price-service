package au.com.nab.smartchoice.productpriceservice.dto.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceModel {
    private String productId;
    private Long price;
    private Long basePrice;
    private String promotion;
    private String location;
    private LocalDateTime syncedAt;
}
