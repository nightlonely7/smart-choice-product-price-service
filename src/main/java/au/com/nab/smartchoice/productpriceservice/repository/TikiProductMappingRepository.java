package au.com.nab.smartchoice.productpriceservice.repository;

import au.com.nab.smartchoice.productpriceservice.dto.entity.TikiProductMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TikiProductMappingRepository extends JpaRepository<TikiProductMappingEntity, UUID> {
    Optional<TikiProductMappingEntity> findByTikiProductTypeId(String tikiProductTypeId);
}
