package au.com.nab.smartchoice.productpriceservice.service.impl;

import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.dto.state.PartnerServiceState;
import au.com.nab.smartchoice.productpriceservice.repository.ProductPriceCacheRepository;
import au.com.nab.smartchoice.productpriceservice.repository.ProductPriceRepository;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import au.com.nab.smartchoice.productpriceservice.service.ProductServiceClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ProductPriceCacheRepository productPriceCacheRepository;
    private final ProductServiceClientService productServiceClientService;
    private final ProductPriceMapper productPriceMapper;

    private final PartnerServiceState partnerServiceState;

    @Override
    public List<ProductPriceModel> getProductPriceList(String productId) {
        var productPriceCacheEntityList = productPriceCacheRepository.findAllByProductId(productId);
        if (!productPriceCacheEntityList.isEmpty()) {
            return productPriceMapper.cacheEntityListToModelList(productPriceCacheEntityList);
        }
        return productPriceMapper.entityListToModelList(productPriceRepository.findAllByProductId(productId)
                .stream().collect(Collectors.toList()));
    }

    @Override
    public void syncProductPrice(PartnerEnum partnerEnum) {

        var partnerService = partnerServiceState.getPartnerService(partnerEnum);

        List<String> synchronizableProductIdList = productServiceClientService.getSynchronizableProductIdList();
        var productPriceModelListList = synchronizableProductIdList.stream()
                .map(partnerService::getProductPrice).filter(not(List::isEmpty)).collect(Collectors.toList());
        System.out.println(productPriceModelListList.size());
        productPriceModelListList.stream().map(e -> e.get(0).getProductId()).forEach(productPriceRepository::deleteAllByProductId);
        productPriceModelListList.stream().map(productPriceMapper::modelListToEntityList)
                .forEach(productPriceRepository::saveAll);
        productPriceModelListList.stream().map(productPriceMapper::modelListToCacheEntityList)
                .forEach(productPriceCacheRepository::saveAll);
    }
}
