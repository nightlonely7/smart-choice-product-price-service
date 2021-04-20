package au.com.nab.smartchoice.productpriceservice.input.scheduler;

import au.com.nab.smartchoice.productpriceservice.feignclient.ProductServiceClient;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPriceTikiSyncScheduler {

    private final ProductPriceService productPriceService;

    @Scheduled(fixedRate = 10000)
    public void syncProductTiki() {
        productPriceService.syncProductPriceTiki();
    }
}
