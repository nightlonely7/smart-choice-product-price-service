package au.com.nab.smartchoice.productpriceservice.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetProductPriceListResponse extends BaseResponse<GetProductPriceListDataResponse> {
}
