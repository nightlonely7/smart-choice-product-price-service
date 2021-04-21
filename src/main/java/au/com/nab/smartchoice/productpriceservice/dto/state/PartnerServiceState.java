package au.com.nab.smartchoice.productpriceservice.dto.state;

import au.com.nab.smartchoice.productpriceservice.dto.other.PartnerEnum;
import au.com.nab.smartchoice.productpriceservice.service.partnerservice.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PartnerServiceState {

    private final PartnerService tikiService;
    private final PartnerService lazadaService;
    private final PartnerService shopeeService;

    public PartnerService getPartnerService(PartnerEnum partnerEnum) {
        switch (partnerEnum) {
            case TIKI:
                return tikiService;
            case LAZADA:
                return lazadaService;
            case SHOPEE:
                return shopeeService;
            default:
                throw new IllegalStateException("Unexpected partnerEnum value: " + partnerEnum);
        }
    }
}
