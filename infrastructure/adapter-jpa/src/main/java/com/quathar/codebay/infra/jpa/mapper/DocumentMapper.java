package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ValueObjectMapperPort;
import com.quathar.codebay.domain.model.valueobject.Document;
import com.quathar.codebay.infra.jpa.entity.embeddable.DocumentEmbeddable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Document Mapper</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentMapper extends ValueObjectMapperPort<Document, DocumentEmbeddable> {

    /**
     * Instance of the DocumentMapper created by MapStruct.
     */
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

}
