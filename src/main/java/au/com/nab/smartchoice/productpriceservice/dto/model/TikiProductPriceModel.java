package au.com.nab.smartchoice.productpriceservice.dto.model;

import lombok.Data;

@Data
public class TikiProductPriceModel {

    private String productTypeId;
    private Long currentPrice;
    private Long marketPrice;
    private String promotion;
    private String location;
}
