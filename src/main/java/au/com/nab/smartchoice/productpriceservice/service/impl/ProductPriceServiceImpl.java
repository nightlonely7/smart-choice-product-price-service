package au.com.nab.smartchoice.productpriceservice.service.impl;

import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.dto.state.PartnerServiceState;
import au.com.nab.smartchoice.productpriceservice.repository.ProductPriceRepository;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import au.com.nab.smartchoice.productpriceservice.service.ProductServiceClientService;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.PartnerService;
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
    private final ProductServiceClientService productServiceClientService;
    private final ProductPriceMapper productPriceMapper;

    private final PartnerServiceState partnerServiceState;

    @Override
    public List<ProductPriceModel> getProductPriceList(String productId) {
        return productPriceRepository.findAllByProductId(productId).stream()
                .map(productPriceMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void syncProductPrice(PartnerEnum partnerEnum) {

        PartnerService partnerService = partnerServiceState.getPartnerService(partnerEnum);

        List<String> synchronizableProductIdList = productServiceClientService.getSynchronizableProductIdList();
        synchronizableProductIdList.stream()
                .map(partnerService::getProductPrice)
                .map(productPriceMapper::modelListToEntityList).collect(Collectors.toList())
                .forEach(productPriceRepository::saveAll);
    }
}
