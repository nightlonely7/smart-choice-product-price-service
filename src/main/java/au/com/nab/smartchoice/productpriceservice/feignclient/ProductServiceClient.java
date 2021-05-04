package au.com.nab.smartchoice.productpriceservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(contextId = "product-service", name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/products/synchronizable")
    ResponseEntity<List<String>> getSynchronizableProductId();
}
