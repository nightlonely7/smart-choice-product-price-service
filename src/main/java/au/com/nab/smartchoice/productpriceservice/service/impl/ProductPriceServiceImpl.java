package au.com.nab.smartchoice.productpriceservice.service.impl;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.repository.ProductPriceRepository;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import au.com.nab.smartchoice.productpriceservice.service.ProductServiceClientService;
import au.com.nab.smartchoice.productpriceservice.service.TikiClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    private final TikiClientService tikiClientService;
    private final ProductServiceClientService productServiceClientService;

    @Override
    public List<ProductPriceModel> getProductPriceList(String productId) {
        return productPriceRepository.findAllByProductId(productId).stream().map(productPriceEntity -> {
            ProductPriceModel productPriceModel = new ProductPriceModel();
            productPriceModel.setProductId(productPriceEntity.getProductId());
            return productPriceModel;
        }).collect(Collectors.toList());
    }

    @Override
    public void syncProductPriceTiki() {

        List<String> synchronizableProductIdList = productServiceClientService.getSynchronizableProductIdList();
        synchronizableProductIdList.stream()
                .map(tikiClientService::getProductPriceTiki)
                .map(productPriceModelList -> productPriceModelList.stream().map(productPriceModel -> {
                            ProductPriceEntity productPriceEntity = new ProductPriceEntity();
                            productPriceEntity.setProductId(productPriceModel.getProductId());
                            return productPriceEntity;
                        }).collect(Collectors.toList())
                ).forEach(productPriceRepository::saveAll);
    }
}
