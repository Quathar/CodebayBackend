package com.quathar.codebay.app.rest.common.model.validation.constraint;

import com.quathar.codebay.app.rest.common.model.validation.validator.AllowedDocumentTypeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Allowed Document Type Constraint</h1>
 *
 * @see AllowedDocumentTypeValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = AllowedDocumentTypeValidator.class)
public @interface AllowedDocumentType {

    String message() default "This document type is not correct or not available";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
