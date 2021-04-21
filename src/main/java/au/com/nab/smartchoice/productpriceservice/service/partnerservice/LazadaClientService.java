package au.com.nab.smartchoice.productpriceservice.service.partnerservice;

import au.com.nab.smartchoice.productpriceservice.dto.model.LazadaProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;

import java.util.List;

public interface LazadaClientService {
    List<LazadaProductPriceModel> getProductPriceLazada(String productId);
}
