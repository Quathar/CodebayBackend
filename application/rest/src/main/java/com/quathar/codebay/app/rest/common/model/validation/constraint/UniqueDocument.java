package com.quathar.codebay.app.rest.common.model.validation.constraint;

import com.quathar.codebay.app.rest.common.model.validation.validator.UniqueDocumentValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Unique Document Annotation</h1>
 *
 * @see UniqueDocumentValidator
 * @since 2024-05-24
 * @version 1.0
 * @author Q
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueDocumentValidator.class)
public @interface UniqueDocument {

    String message() default "This document already exist, if this is your document number please contact with us";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
