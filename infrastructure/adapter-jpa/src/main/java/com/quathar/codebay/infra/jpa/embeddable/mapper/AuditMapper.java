package com.quathar.codebay.infra.jpa.embeddable.mapper;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.Audit;
import com.quathar.codebay.infra.jpa.embeddable.AuditEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Document Mapper</h1>
 *
 * @see MapperServicePort
 * @see Audit
 * @see AuditEmbeddable
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface AuditMapper extends MapperServicePort<Audit, AuditEmbeddable> {
}
