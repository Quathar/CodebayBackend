package com.quathar.codebay.app.rest.shop.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpCartResponseMapper;
import com.quathar.codebay.app.rest.common.model.mapper.response.CartDetailResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicCartResponse;
import com.quathar.codebay.domain.model.shop.ShoppingCart;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic Cart Response Mapper</h1>
 *
 * @see HttpCartResponseMapper
 * @see BasicCartResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE, uses = CartDetailResponseMapper.class)
public interface BasicCartResponseMapper extends HttpCartResponseMapper<BasicCartResponse> {

    @Override
    @Mapping(source = "customer.username", target = "username")
    BasicCartResponse fromModel(ShoppingCart model);

}
