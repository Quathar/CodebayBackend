package com.quathar.codebay.app.rest.shop.model.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.generic.request.HttpProductFiltersRequestMapper;
import com.quathar.codebay.app.rest.shop.model.request.ShopProductParams;
import com.quathar.codebay.domain.model.shop.ProductFilters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Shop Product Parameters Mapper</h1>
 *
 * @see HttpProductFiltersRequestMapper
 * @see ShopProductParams
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ShopProductParamsMapper extends HttpProductFiltersRequestMapper<ShopProductParams> {

    @Override
    @Mapping(source = "page", target = "pageIndex")
    @Mapping(source = "size", target = "pageSize")
    ProductFilters toModel(ShopProductParams other);

}
