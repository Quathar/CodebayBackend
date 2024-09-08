package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.domain.port.out.option.BaseOptionRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.BaseOption;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <h1>Allowed Base Option Validator</h1>
 *
 * @param <M> The type of {@link BaseOption} value object.
 * @param <C> The type of constraint used for validation.
 *
 * @see ConstraintValidator
 * @see BaseOption
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Slf4j
@AllArgsConstructor
public abstract class AllowedBaseOptionValidator<M extends BaseOption, C extends java.lang.annotation.Annotation>
       implements     ConstraintValidator<C, String> {

    // <<-FIELD->>
    /**
     * The base option repository port.
     */
    private final BaseOptionRepositoryPort<M> baseOptionRepositoryPort;

    // <<-METHOD->>
    @Override
    public boolean isValid(String codeToCheck, ConstraintValidatorContext context) {
        log.debug("");
        return this.baseOptionRepositoryPort
                .findAll()
                .map(BaseOption::getCode)
                .anyMatch(code -> code.equals(codeToCheck));
    }

}
