package au.com.nab.smartchoice.productpriceservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetProductPriceListDataResponse {

    @JsonProperty("product_price_list")
    private List<ProductPriceResponse> productPriceList;
}
