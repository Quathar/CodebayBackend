package com.quathar.codebay.app.rest.shop.model.mapper.response;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpProductResponseMapper;
import com.quathar.codebay.app.rest.shop.model.response.BasicProductResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Basic Product Response Mapper</h1>
 *
 * @see HttpProductResponseMapper
 * @see BasicProductResponse
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface BasicProductResponseMapper extends HttpProductResponseMapper<BasicProductResponse> {
}
