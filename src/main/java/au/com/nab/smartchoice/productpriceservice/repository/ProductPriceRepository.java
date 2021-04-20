package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, UUID> {
}
