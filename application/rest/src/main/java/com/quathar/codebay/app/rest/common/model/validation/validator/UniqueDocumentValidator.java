package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.UniqueDocument;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * <h1>Unique Document Validator</h1>
 *
 * @see UniqueDocument
 * @since 2024-05-24
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class UniqueDocumentValidator implements ConstraintValidator<UniqueDocument, String> {

    // <<-FIELD->>
    private final CustomerRepositoryPort customerRepositoryPort;

    // <<-METHOD->>
    @Override
    public boolean isValid(String documentContent, ConstraintValidatorContext context) {
        return this.customerRepositoryPort
                .existsByDocument(documentContent);
    }

}
