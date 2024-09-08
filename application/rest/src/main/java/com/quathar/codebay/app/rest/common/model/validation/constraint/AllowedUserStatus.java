package com.quathar.codebay.app.rest.common.model.validation.constraint;

import com.quathar.codebay.app.rest.common.model.validation.validator.AllowedUserStatusValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Allowed User Status Constraint</h1>
 *
 * @see AllowedUserStatusValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = AllowedUserStatusValidator.class)
public @interface AllowedUserStatus {

    String message() default "This user status is not correct or not available";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
