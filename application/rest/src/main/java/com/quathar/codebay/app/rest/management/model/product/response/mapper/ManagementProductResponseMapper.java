package com.quathar.codebay.app.rest.management.model.product.response.mapper;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpProductResponseMapper;
import com.quathar.codebay.app.rest.management.model.product.response.ManagementProductResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Management Product Response Mapper</h1>
 *
 * @see HttpProductResponseMapper
 * @see ManagementProductResponse
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface ManagementProductResponseMapper extends HttpProductResponseMapper<ManagementProductResponse> {
}
