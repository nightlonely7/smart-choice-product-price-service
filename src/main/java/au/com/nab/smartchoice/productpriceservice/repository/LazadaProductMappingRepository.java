package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.LazadaProductMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LazadaProductMappingRepository extends JpaRepository<LazadaProductMappingEntity, UUID> {
    Optional<LazadaProductMappingEntity> findByLazadaItemId(String lazadaItemId);
}
