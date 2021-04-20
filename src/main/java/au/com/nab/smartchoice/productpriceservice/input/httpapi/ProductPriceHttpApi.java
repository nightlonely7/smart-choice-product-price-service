package au.com.nab.smartchoice.productpriceservice.input.httpapi;

import au.com.nab.smartchoice.productpriceservice.dto.httpresponse.ProductPriceHttpResponse;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductPriceHttpApi {

    private final ProductPriceService productPriceService;

    @GetMapping
    public ResponseEntity<?> getProductPriceList(@RequestParam("product-id") String productId) {
        return ResponseEntity.ok(productPriceService.getProductPriceList(productId).stream().map(productPriceModel -> {
            ProductPriceHttpResponse productPriceHttpResponse = new ProductPriceHttpResponse();
            productPriceHttpResponse.setProductId(productPriceModel.getProductId());
            return productPriceHttpResponse;
        }).collect(Collectors.toList()));
    }
}
