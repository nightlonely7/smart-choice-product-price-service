package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ShopeeProductMappingEntity;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.repository.ShopeeProductMappingRepository;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.ShopeeService;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.ShopeeWebCrawlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service("shopeeService")
@RequiredArgsConstructor
@Slf4j
public class ShopeeServiceImpl implements ShopeeService {

    private final ShopeeWebCrawlerService shopeeWebCrawlerService;
    private final ShopeeProductMappingRepository shopeeProductMappingRepository;

    @Override
    public List<ProductPriceModel> getProductPrice(String productId) {
        return shopeeWebCrawlerService.getProductPriceShopee(productId).stream()
                .map(shopeeProductPriceModel -> {
                    ShopeeProductMappingEntity shopeeProductMappingEntity = shopeeProductMappingRepository.findByShopeeProductName(shopeeProductPriceModel.getProductName())
                            .orElseThrow();
                    ProductPriceModel productPriceModel = new ProductPriceModel();
                    productPriceModel.setProductId(shopeeProductMappingEntity.getProductId());
                    productPriceModel.setPartner(PartnerEnum.SHOPEE.getPartnerCode());
                    productPriceModel.setPrice(shopeeProductPriceModel.getPrice());
                    productPriceModel.setBasePrice(shopeeProductPriceModel.getBasePrice());
                    productPriceModel.setPromotion(shopeeProductPriceModel.getPromotion());
                    productPriceModel.setLocation(shopeeProductPriceModel.getLocation());
                    productPriceModel.setSyncedAt(LocalDateTime.now());
                    return productPriceModel;
                }).collect(Collectors.toList());
    }
}
