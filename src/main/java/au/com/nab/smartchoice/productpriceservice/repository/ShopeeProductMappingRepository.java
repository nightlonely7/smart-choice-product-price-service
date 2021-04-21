package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ShopeeProductMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShopeeProductMappingRepository extends JpaRepository<ShopeeProductMappingEntity, UUID> {
    Optional<ShopeeProductMappingEntity> findByShopeeProductName(String shopeeProductName);
}
