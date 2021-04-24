package au.com.nab.smartchoice.productpriceservice.input.scheduler;

import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
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

    @Scheduled(fixedRate = 30000)
    public void syncProductTiki() {
        productPriceService.syncProductPrice(PartnerEnum.TIKI);
    }

//    @Scheduled(fixedRate = 30000)
    public void syncProductLazada() {
        productPriceService.syncProductPrice(PartnerEnum.LAZADA);
    }

//    @Scheduled(fixedRate = 30000)
    public void syncProductShopee() {
        productPriceService.syncProductPrice(PartnerEnum.SHOPEE);
    }
}
