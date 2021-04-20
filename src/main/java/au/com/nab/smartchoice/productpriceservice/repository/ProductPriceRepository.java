package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.UUID;

public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, UUID> {
    Streamable<ProductPriceEntity> findAllByProductId(String productId);
}
