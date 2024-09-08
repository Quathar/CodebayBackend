package com.quathar.codebay.app.rest.shop.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpOrderResponseMapper;
import com.quathar.codebay.app.rest.common.model.mapper.response.OrderDetailResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicOrderResponse;
import com.quathar.codebay.domain.model.shop.Order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic Order Response Mapper</h1>
 *
 * @see HttpOrderResponseMapper
 * @see BasicOrderResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE, uses = OrderDetailResponseMapper.class)
public interface BasicOrderResponseMapper extends HttpOrderResponseMapper<BasicOrderResponse> {

    @Override
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "customer.username", target = "username")
    BasicOrderResponse fromModel(Order model);

}
