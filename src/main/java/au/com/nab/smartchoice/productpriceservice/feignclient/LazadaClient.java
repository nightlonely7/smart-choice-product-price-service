package au.com.nab.smartchoice.productpriceservice.feignclient;

import au.com.nab.smartchoice.productpriceservice.dto.httpreception.LazadaGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "lazada-client", name = "lazada-client", path = "/")
public interface LazadaClient {

    @GetMapping("/items")
    ResponseEntity<List<LazadaGetProductPriceHttpReception>> getProduct(@RequestHeader HttpHeaders httpHeaders,
                                                                        @RequestParam("itemId") String itemId);

    @GetMapping("/auth")
    ResponseEntity<String> getToken(@RequestHeader HttpHeaders httpHeaders);
}
