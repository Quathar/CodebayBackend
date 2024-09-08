package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.UniqueUsername;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

/**
 * <h1>Unique Username Validator</h1>
 *
 * @see UniqueUsername
 * @since 2024-05-24
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    // <<-FIELD->>
    private final UserRepositoryPort userRepositoryPort;

    // <<-METHOD->>
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return this.userRepositoryPort
                .findByUsername(username)
                .isEmpty();
    }

}
