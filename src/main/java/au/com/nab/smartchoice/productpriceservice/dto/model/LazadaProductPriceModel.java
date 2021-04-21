package au.com.nab.smartchoice.productpriceservice.dto.model;

import lombok.Data;

@Data
public class LazadaProductPriceModel {
    private String itemId;
    private Long price;
    private Long originalPrice;
    private String promotion;
    private String location;
}
