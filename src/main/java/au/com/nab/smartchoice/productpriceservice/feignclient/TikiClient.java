package au.com.nab.smartchoice.productpriceservice.feignclient;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "tiki-client", name = "tiki-client", url = "https://fd9f7ff2-cc9b-4a41-9eef-a1c991e9a390.mock.pstmn.io")
public interface TikiClient {

    @GetMapping("/products")
    ResponseEntity<List<TikiGetProductPriceHttpReception>> getProduct(@RequestHeader HttpHeaders httpHeaders,
                                                                      @RequestParam("product_id") String productId);
}
