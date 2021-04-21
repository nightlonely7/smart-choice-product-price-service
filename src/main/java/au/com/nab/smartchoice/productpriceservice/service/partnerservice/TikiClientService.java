package au.com.nab.smartchoice.productpriceservice.service.partnerservice;

import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.TikiProductPriceModel;

import java.util.List;

public interface TikiClientService {
    List<TikiProductPriceModel> getProductPriceTiki(String productId);
}
