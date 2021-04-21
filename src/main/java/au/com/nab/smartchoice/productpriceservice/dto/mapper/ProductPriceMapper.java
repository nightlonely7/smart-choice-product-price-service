package au.com.nab.smartchoice.productpriceservice.dto.mapper;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import au.com.nab.smartchoice.productpriceservice.dto.httpreception.LazadaGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.httpresponse.ProductPriceHttpResponse;
import au.com.nab.smartchoice.productpriceservice.dto.model.LazadaProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.TikiProductPriceModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductPriceMapper {

    ProductPriceModel entityToModel(ProductPriceEntity productPriceEntity);

    ProductPriceEntity modelToEntity(ProductPriceModel productPriceModel);

    List<ProductPriceEntity> modelListToEntityList(List<ProductPriceModel> productPriceModel);

    ProductPriceHttpResponse modelToResponse(ProductPriceModel productPriceModel);

    TikiProductPriceModel tikiHttpReceptionToModel(TikiGetProductPriceHttpReception tikiGetProductPriceHttpReception);

    LazadaProductPriceModel lazadaHttpReceptionToModel(LazadaGetProductPriceHttpReception lazadaGetProductPriceHttpReception);

}
