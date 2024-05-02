package com.quathar.codebay.app.rest.management.model.mapper;

import com.quathar.codebay.app.rest.management.model.response.AuditResponse;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;
import com.quathar.codebay.domain.valueobject.Audit;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Audit Response Mapper</h1>
 *
 * @since 2024-04-28
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface AuditResponseMapper extends MapFromModel<Audit, AuditResponse> {
}
