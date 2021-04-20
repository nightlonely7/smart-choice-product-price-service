package au.com.nab.smartchoice.productpriceservice.dto.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product_price")
public class ProductPriceEntity {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private Long price;

    @Column(name = "base_price")
    private Long basePrice;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "location")
    private String location;

    @Column(name = "synced_at")
    private LocalDateTime syncedAt;


}
