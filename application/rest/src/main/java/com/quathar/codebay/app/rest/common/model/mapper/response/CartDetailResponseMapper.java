package com.quathar.codebay.app.rest.common.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.response.CartDetailResponse;
import com.quathar.codebay.domain.model.shop.CartDetail;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Cart Detail Response Mapper</h1>
 *
 * @see MapFromModel
 * @see CartDetail
 * @see CartDetailResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface CartDetailResponseMapper extends MapFromModel<CartDetail, CartDetailResponse> {

    @Override
    @Mapping(source = "product.code", target = "productCode")
    CartDetailResponse fromModel(CartDetail model);

}
