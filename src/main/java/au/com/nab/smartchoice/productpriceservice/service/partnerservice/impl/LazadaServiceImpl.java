package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.entity.LazadaProductMappingEntity;
import au.com.nab.smartchoice.productpriceservice.dto.entity.TikiProductMappingEntity;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.repository.LazadaProductMappingRepository;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.LazadaClientService;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.LazadaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service("lazadaService")
@Slf4j
@RequiredArgsConstructor
public class LazadaServiceImpl implements LazadaService {

    private final LazadaClientService lazadaClientService;
    private final LazadaProductMappingRepository lazadaProductMappingRepository;

    @Override
    public List<ProductPriceModel> getProductPrice(String productId) {
        return lazadaClientService.getProductPriceLazada(productId).stream()
                .map(lazadaProductPriceModel -> {
                    LazadaProductMappingEntity lazadaProductMappingEntity = lazadaProductMappingRepository.findByLazadaItemId(lazadaProductPriceModel.getItemId())
                            .orElseThrow();
                    ProductPriceModel productPriceModel = new ProductPriceModel();
                    productPriceModel.setProductId(lazadaProductMappingEntity.getProductId());
                    productPriceModel.setPartner(PartnerEnum.LAZADA.getPartnerCode());
                    productPriceModel.setPrice(lazadaProductPriceModel.getPrice());
                    productPriceModel.setBasePrice(lazadaProductPriceModel.getOriginalPrice());
                    productPriceModel.setPromotion(lazadaProductPriceModel.getPromotion());
                    productPriceModel.setLocation(lazadaProductPriceModel.getLocation());
                    productPriceModel.setSyncedAt(LocalDateTime.now());
                    return productPriceModel;
                }).collect(Collectors.toList());
    }
}
