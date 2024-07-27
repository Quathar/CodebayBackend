package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.DocumentTypeRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.DocumentType;
import com.quathar.codebay.infra.jpa.entity.option.DocumentTypeEntity;
import com.quathar.codebay.infra.jpa.mapper.option.DocumentTypeMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaDocumentTypeRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Document Type Repository Adapter</h1>
 *
 * @see DocumentTypeRepositoryPort
 * @see JpaBaseOptionRepositoryAdapter
 * @see DocumentType
 * @see DocumentTypeEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaDocumentTypeRepositoryAdapter
       extends     JpaBaseOptionRepositoryAdapter<DocumentType, DocumentTypeEntity>
       implements  DocumentTypeRepositoryPort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaDocumentTypeRepositoryAdapter} for the {@link DocumentTypeRepositoryPort}
     * with the specified {@link JpaDocumentTypeRepository} and {@link DocumentTypeMapper}.
     *
     * @param jpaDocumentTypeRepository The JPA repository for {@link DocumentTypeEntity}.
     * @param documentTypeMapper        The mapper for converting between {@link DocumentType} and {@link DocumentTypeEntity}.
     */
    public JpaDocumentTypeRepositoryAdapter(JpaDocumentTypeRepository jpaDocumentTypeRepository, DocumentTypeMapper documentTypeMapper) {
        super(jpaDocumentTypeRepository, documentTypeMapper);
    }

}
