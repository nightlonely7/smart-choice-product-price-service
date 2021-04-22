package au.com.nab.smartchoice.productpriceservice.repository.impl;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceCacheEntity;
import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import au.com.nab.smartchoice.productpriceservice.dto.mapper.ProductPriceMapper;
import au.com.nab.smartchoice.productpriceservice.repository.ProductPriceCacheRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductPriceCacheRepositoryRedisImpl implements ProductPriceCacheRepository {

    private static final String PRODUCT_PRICE_HASH = "PRODUCT_PRICE";

    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public List<ProductPriceCacheEntity> findAllByProductId(String productId) {
        String productPriceCacheListStr =
                (String) stringRedisTemplate.opsForHash().get(PRODUCT_PRICE_HASH, productId);
        if (productPriceCacheListStr == null) {
            return Collections.emptyList();
        }
        List<ProductPriceCacheEntity> productPriceEntityList = null;
        try {
            productPriceEntityList = objectMapper.readValue(productPriceCacheListStr,
                    objectMapper.getTypeFactory().constructArrayType(ProductPriceCacheEntity.class));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        return productPriceEntityList;
    }

    @Override
    public void saveAll(Iterable<ProductPriceCacheEntity> productPriceCacheEntityList) {
        String productId = productPriceCacheEntityList.iterator().next().getProductId();
        try {
            stringRedisTemplate.opsForHash().put(PRODUCT_PRICE_HASH, productId, objectMapper.writeValueAsString(productPriceCacheEntityList));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }

}
