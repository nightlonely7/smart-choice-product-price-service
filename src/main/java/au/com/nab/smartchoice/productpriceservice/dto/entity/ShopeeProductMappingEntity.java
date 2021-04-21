package au.com.nab.smartchoice.productpriceservice.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shopee_product_mapping")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopeeProductMappingEntity extends BaseEntity {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "shopee_product_name")
    private String shopeeProductName;
}
