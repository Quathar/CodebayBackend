package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.UniqueEmail;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * <h1>Unique Email Validator</h1>
 *
 * @see UniqueEmail
 * @since 2024-05-24
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    // <<-FIELD->>
    private final UserRepositoryPort userRepositoryPort;

    // <<-METHOD->>
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return this.userRepositoryPort
                .findByEmail(email)
                .isEmpty();
    }

}
