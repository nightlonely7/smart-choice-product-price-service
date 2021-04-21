package au.com.nab.smartchoice.productpriceservice.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lazada_product_mapping")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LazadaProductMappingEntity extends BaseEntity {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "lazada_item_id")
    private String lazadaItemId;
}
