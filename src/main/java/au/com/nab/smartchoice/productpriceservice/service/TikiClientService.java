package au.com.nab.smartchoice.productpriceservice.service;

import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;

import java.util.List;

public interface TikiClientService {
    List<ProductPriceModel> getProductPriceTiki(String productId);
}
