package com.quathar.codebay.app.rest.common.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.response.OrderDetailResponse;
import com.quathar.codebay.domain.model.shop.OrderDetail;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Order Detail Response Mapper</h1>
 *
 * @see MapFromModel
 * @see OrderDetail
 * @see OrderDetailResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface OrderDetailResponseMapper extends MapFromModel<OrderDetail, OrderDetailResponse> {

    @Override
    @Mapping(source = "product.code", target = "productCode")
    OrderDetailResponse fromModel(OrderDetail model);

}
