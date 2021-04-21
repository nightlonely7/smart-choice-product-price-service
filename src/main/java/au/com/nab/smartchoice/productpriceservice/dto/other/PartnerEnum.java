package au.com.nab.smartchoice.productpriceservice.dto.other;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PartnerEnum {
    TIKI("TKI"),
    LAZADA("LZD"),
    SHOPEE("SPE");

    private final String partnerCode;
}
