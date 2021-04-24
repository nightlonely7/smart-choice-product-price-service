package au.com.nab.smartchoice.productpriceservice.feignclient;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "tiki-client", name = "tiki-client", url = "https://b6fb7a85-482f-47c4-b689-09655f87a6bd.mock.pstmn.io")
public interface TikiClient {

    @GetMapping("/products")
    ResponseEntity<List<TikiGetProductPriceHttpReception>> getProduct(@RequestHeader HttpHeaders httpHeaders,
                                                                      @RequestParam("product-id") String productId);
}
