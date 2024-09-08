package com.quathar.codebay.app.rest.management.model.product.request.mapper;

import com.quathar.codebay.app.rest.common.model.mapper.generic.request.HttpProductFiltersRequestMapper;
import com.quathar.codebay.app.rest.management.model.product.request.ManagementProductParams;
import com.quathar.codebay.domain.model.shop.ProductFilters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Management Product Parameters Mapper</h1>
 *
 * @see HttpProductFiltersRequestMapper
 * @see ManagementProductParams
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ManagementProductParamsMapper
       extends   HttpProductFiltersRequestMapper<ManagementProductParams> {

    @Override
    @Mapping(source = "page", target = "pageIndex")
    @Mapping(source = "size", target = "pageSize")
    ProductFilters toModel(ManagementProductParams other);

}
