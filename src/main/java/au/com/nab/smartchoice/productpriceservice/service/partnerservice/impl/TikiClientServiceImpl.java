package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.dto.model.TikiProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.feignclient.TikiClient;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.TikiClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TikiClientServiceImpl implements TikiClientService {

    private final TikiClient tikiClient;
    private final ProductPriceMapper productPriceMapper;

    @Override
    public List<TikiProductPriceModel> getProductPriceTiki(String productId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth("username", "password");
        ResponseEntity<List<TikiGetProductPriceHttpReception>> responseEntity = tikiClient.getProduct(httpHeaders, productId);
        var getProductPriceHttpReceptionList = responseEntity.getBody();
        if (getProductPriceHttpReceptionList == null || getProductPriceHttpReceptionList.isEmpty()) {
            return Collections.emptyList();
        }
        return responseEntity.getBody().stream()
                .map(productPriceMapper::tikiHttpReceptionToModel)
                .collect(Collectors.toList());
    }
}
