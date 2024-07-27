package com.quathar.codebay.app.rest.management.model.product.response.mapper;

import com.quathar.codebay.app.rest.common.model.mapper.generic.response.HttpProductResponseMapper;
import com.quathar.codebay.app.rest.management.model.mapper.AuditResponseMapper;
import com.quathar.codebay.app.rest.management.model.product.response.FullProductResponse;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Full Product Response Mapper</h1>
 *
 * @see HttpProductResponseMapper
 * @see FullProductResponse
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Mapper(uses = AuditResponseMapper.class, unmappedTargetPolicy = IGNORE)
public interface FullProductResponseMapper extends HttpProductResponseMapper<FullProductResponse> {
}
