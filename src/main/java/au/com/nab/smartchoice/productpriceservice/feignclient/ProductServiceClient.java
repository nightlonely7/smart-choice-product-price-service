package au.com.nab.smartchoice.productpriceservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

@FeignClient(contextId = "tiki", path = "tiki")
public interface ProductServiceClient {
    ResponseEntity<List<String>> getSynchronizableProductId();
}
