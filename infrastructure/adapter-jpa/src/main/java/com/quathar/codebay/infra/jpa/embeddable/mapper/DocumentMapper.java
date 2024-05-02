package com.quathar.codebay.infra.jpa.embeddable.mapper;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.Document;
import com.quathar.codebay.infra.jpa.embeddable.DocumentEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Document Mapper</h1>
 *
 * @see MapperServicePort
 * @see Document
 * @see DocumentEmbeddable
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface DocumentMapper extends MapperServicePort<Document, DocumentEmbeddable> {
}
