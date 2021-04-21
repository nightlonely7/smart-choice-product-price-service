package au.com.nab.smartchoice.productpriceservice.service.partnerservice;

import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;

import java.util.List;

public interface PartnerService {
    List<ProductPriceModel> getProductPrice(String productId);
}
