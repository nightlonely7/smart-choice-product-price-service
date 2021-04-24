package au.com.nab.smartchoice.productpriceservice.input.httpapi;

import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.dto.response.GetProductPriceListDataResponse;
import au.com.nab.smartchoice.productpriceservice.dto.response.GetProductPriceListResponse;
import au.com.nab.smartchoice.productpriceservice.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static au.com.nab.smartchoice.productpriceservice.utility.Constant.NOT_FOUND_RESPONSE_CODE;
import static au.com.nab.smartchoice.productpriceservice.utility.Constant.OBTAINED_RESPONSE_CODE;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/product-prices")
public class ProductPriceHttpApi {

    private final ProductPriceService productPriceService;
    private final ProductPriceMapper productPriceMapper;

    @GetMapping
    public ResponseEntity<?> getProductPriceList(@RequestParam("product-id") String productId) {

        var productPriceModelList = productPriceService.getProductPriceList(productId);

        var getProductPriceListResponse = new GetProductPriceListResponse();
        if (productPriceModelList.isEmpty()) {
            getProductPriceListResponse.setCode(NOT_FOUND_RESPONSE_CODE);
            getProductPriceListResponse.setMessage("Product price not found.");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getProductPriceListResponse);
        }
        getProductPriceListResponse.setCode(OBTAINED_RESPONSE_CODE);
        getProductPriceListResponse.setMessage("Product price obtained.");
        var getProductPriceListDataResponse = new GetProductPriceListDataResponse();
        getProductPriceListDataResponse.setProductPriceList(
                productPriceMapper.modelListToResponseList(productPriceModelList));
        getProductPriceListResponse.setData(getProductPriceListDataResponse);

        return ResponseEntity.ok(getProductPriceListResponse);
    }
}
