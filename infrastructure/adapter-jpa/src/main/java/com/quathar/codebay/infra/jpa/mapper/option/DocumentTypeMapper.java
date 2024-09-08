package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.valueobject.option.DocumentType;
import com.quathar.codebay.infra.jpa.entity.option.DocumentTypeEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Document Type Mapper</h1>
 *
 * @see BaseOptionMapper
 * @see DocumentType
 * @see DocumentTypeEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface DocumentTypeMapper extends BaseOptionMapper<DocumentType, DocumentTypeEntity> {
}
