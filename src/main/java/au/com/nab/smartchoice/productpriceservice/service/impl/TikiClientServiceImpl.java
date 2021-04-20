package au.com.nab.smartchoice.productpriceservice.service.impl;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.feignclient.TikiClient;
import au.com.nab.smartchoice.productpriceservice.service.TikiClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TikiClientServiceImpl implements TikiClientService {

    private final TikiClient tikiClient;

    @Override
    public List<ProductPriceModel> getProductPriceTiki(String productId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<TikiGetProductPriceHttpReception> responseEntity = tikiClient.getProduct(httpHeaders, productId);
        List<ProductPriceModel> productPriceModelList = new ArrayList<>();
        return productPriceModelList;
    }
}
