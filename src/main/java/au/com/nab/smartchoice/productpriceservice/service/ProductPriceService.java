package au.com.nab.smartchoice.productpriceservice.service;

import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;

import java.util.List;

public interface ProductPriceService {
    List<ProductPriceModel> getProductPriceList(String productId);

    void syncProductPriceTiki();
}
