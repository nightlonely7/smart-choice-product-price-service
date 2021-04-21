package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceCacheEntity;

import java.util.List;

public interface ProductPriceCacheRepository {
    List<ProductPriceCacheEntity> findAllByProductId(String productId);

    void saveAll(Iterable<ProductPriceCacheEntity> productPriceCacheEntityList);
}
