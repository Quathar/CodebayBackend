package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedDocumentType;
import com.quathar.codebay.domain.port.out.option.DocumentTypeRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.DocumentType;

import org.springframework.stereotype.Component;

/**
 * <h1>Allowed Document Type Validator</h1>
 *
 * @see AllowedDocumentType
 * @see AllowedBaseOptionValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Component
public final class AllowedDocumentTypeValidator
       extends     AllowedBaseOptionValidator<DocumentType, AllowedDocumentType> {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link AllowedDocumentTypeValidator}
     * with the specified {@link DocumentTypeRepositoryPort}.
     *
     * @param documentTypeRepositoryPort The {@link DocumentType} repository port.
     */
    public AllowedDocumentTypeValidator(DocumentTypeRepositoryPort documentTypeRepositoryPort) {
        super(documentTypeRepositoryPort);
    }

}
