package au.com.nab.smartchoice.productpriceservice.service.impl;

import au.com.nab.smartchoice.productpriceservice.feignclient.ProductServiceClient;
import au.com.nab.smartchoice.productpriceservice.service.ProductServiceClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceClientServiceImpl implements ProductServiceClientService {

    private final ProductServiceClient productServiceClient;

    @Override
    public List<String> getSynchronizableProductIdList() {
        return productServiceClient.getSynchronizableProductId().getBody();
    }
}
