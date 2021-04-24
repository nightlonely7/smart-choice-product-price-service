package au.com.nab.smartchoice.productpriceservice.dto.mapper;

import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceCacheEntity;
import au.com.nab.smartchoice.productpriceservice.dto.entity.ProductPriceEntity;
import au.com.nab.smartchoice.productpriceservice.dto.httpreception.LazadaGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.httpreception.TikiGetProductPriceHttpReception;
import au.com.nab.smartchoice.productpriceservice.dto.response.ProductPriceResponse;
import au.com.nab.smartchoice.productpriceservice.dto.model.LazadaProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.ProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.dto.model.TikiProductPriceModel;
import au.com.nab.smartchoice.productpriceservice.utility.Constant;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProductPriceMapper {

    ProductPriceModel entityToModel(ProductPriceEntity productPriceEntity);
    List<ProductPriceModel> entityListToModelList(List<ProductPriceEntity> productPriceEntity);

    List<ProductPriceResponse> modelListToResponseList(List<ProductPriceModel> productPriceModelList);

    ProductPriceEntity modelToEntity(ProductPriceModel productPriceModel);

    List<ProductPriceEntity> modelListToEntityList(List<ProductPriceModel> productPriceModel);

    ProductPriceResponse modelToResponse(ProductPriceModel productPriceModel);

    TikiProductPriceModel tikiHttpReceptionToModel(TikiGetProductPriceHttpReception tikiGetProductPriceHttpReception);

    LazadaProductPriceModel lazadaHttpReceptionToModel(LazadaGetProductPriceHttpReception lazadaGetProductPriceHttpReception);

    List<ProductPriceModel> cacheEntityListToModelList(List<ProductPriceCacheEntity> productPriceCacheEntityList);

    List<ProductPriceCacheEntity> modelListToCacheEntityList(List<ProductPriceModel> productPriceModelList);

    default String localDateTimeToString(LocalDateTime localDateTime) {
        return Constant.DATE_TIME_FORMATTER.format(localDateTime);
    }

    default LocalDateTime stringToLocalDateTime(String s) {
        return LocalDateTime.parse(s, Constant.DATE_TIME_FORMATTER);
    }
}
