package au.com.nab.smartchoice.productpriceservice.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tiki_product_mapping")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TikiProductMappingEntity extends BaseEntity {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "tiki_product_type_id")
    private String tikiProductTypeId;
}
