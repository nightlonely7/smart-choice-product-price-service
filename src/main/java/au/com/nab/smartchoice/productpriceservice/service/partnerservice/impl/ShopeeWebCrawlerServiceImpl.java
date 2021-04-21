package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.model.ShopeeProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.ShopeeWebCrawlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopeeWebCrawlerServiceImpl implements ShopeeWebCrawlerService {

    @Override
    public List<ShopeeProductPriceModel> getProductPriceShopee(String productId) {
        List<ShopeeProductPriceModel> shopeeProductPriceModelList = new ArrayList<>();
        return shopeeProductPriceModelList;
    }
}
