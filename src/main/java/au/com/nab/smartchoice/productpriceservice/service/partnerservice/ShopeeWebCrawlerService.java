package au.com.nab.smartchoice.productpriceservice.service.partnerservice;

import au.com.nab.smartchoice.productpriceservice.dto.model.ShopeeProductPriceModel;

import java.util.List;

public interface ShopeeWebCrawlerService {
    List<ShopeeProductPriceModel> getProductPriceShopee(String productId);
}
