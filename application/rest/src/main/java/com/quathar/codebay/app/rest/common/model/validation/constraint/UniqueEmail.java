package com.quathar.codebay.app.rest.common.model.validation.constraint;

import com.quathar.codebay.app.rest.common.model.validation.validator.UniqueEmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Unique Email Annotation</h1>
 *
 * @see UniqueEmailValidator
 * @since 2024-05-24
 * @version 1.0
 * @author Q
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

    String message() default "This email already exist, please choose another one";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
