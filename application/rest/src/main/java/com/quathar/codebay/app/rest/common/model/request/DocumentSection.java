package com.quathar.codebay.app.rest.common.model.request;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedDocumentType;
import com.quathar.codebay.app.rest.common.model.validation.constraint.UniqueDocument;

import jakarta.validation.constraints.NotBlank;

/**
 * <h1>Document Section</h1>
 *
 * @param type    the type of the document (e.g., passport, ID card)
 * @param content the content of the document (e.g., document number)
 *
 * @see com.quathar.codebay.domain.valueobject.Document
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record DocumentSection(
        @NotBlank
        @AllowedDocumentType
        String type,
        @NotBlank
        @UniqueDocument
        String content
) {}
