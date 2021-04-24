package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.entity.TikiProductMappingEntity;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.repository.TikiProductMappingRepository;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.TikiClientService;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.TikiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static au.com.nab.smartchoice.productpriceservice.utility.Constant.notFoundException;

@Service("tikiService")
@Slf4j
@RequiredArgsConstructor
public class TikiServiceImpl implements TikiService {

    private final TikiClientService tikiClientService;
    private final TikiProductMappingRepository tikiProductMappingRepository;

    @Override
    public List<ProductPriceModel> getProductPrice(String productId) {
        return tikiClientService.getProductPriceTiki(productId).stream()
                .map(tikiProductPriceModel -> {
                    TikiProductMappingEntity tikiProductMappingEntity = tikiProductMappingRepository.findByTikiProductTypeId(tikiProductPriceModel.getProductTypeId())
                            .orElseThrow(notFoundException("productId", tikiProductPriceModel.getProductTypeId()));
                    ProductPriceModel productPriceModel = new ProductPriceModel();
                    productPriceModel.setProductId(tikiProductMappingEntity.getProductId());
                    productPriceModel.setPartner(PartnerEnum.TIKI.getPartnerCode());
                    productPriceModel.setPrice(tikiProductPriceModel.getCurrentPrice());
                    productPriceModel.setBasePrice(tikiProductPriceModel.getMarketPrice());
                    productPriceModel.setPromotion(tikiProductPriceModel.getPromotion());
                    productPriceModel.setLocation(tikiProductPriceModel.getLocation());
                    productPriceModel.setSyncedAt(LocalDateTime.now());
                    return productPriceModel;
                }).collect(Collectors.toList());
    }
}
