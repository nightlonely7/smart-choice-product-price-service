package au.com.nab.smartchoice.productpriceservice.service.partnerservice.impl;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.LazadaGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.dto.model.LazadaProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.feignclient.LazadaClient;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.LazadaClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LazadaClientServiceImpl implements LazadaClientService {

    private final LazadaClient lazadaClient;
    private final ProductPriceMapper productPriceMapper;

    @Override
    public List<LazadaProductPriceModel> getProductPriceLazada(String productId) {
        HttpHeaders authHttpHeaders = new HttpHeaders();
        authHttpHeaders.setBasicAuth("username", "password");
        String token = lazadaClient.getToken(authHttpHeaders).getBody();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        ResponseEntity<List<LazadaGetProductPriceHttpReception>> responseEntity = lazadaClient.getProduct(httpHeaders, productId);
        return responseEntity.getBody().stream()
                .map(productPriceMapper::lazadaHttpReceptionToModel)
                .collect(Collectors.toList());
    }
}
