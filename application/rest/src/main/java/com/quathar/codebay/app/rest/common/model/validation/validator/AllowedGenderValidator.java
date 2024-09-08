package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedGender;
import com.quathar.codebay.domain.port.out.option.GenderRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.Gender;

import org.springframework.stereotype.Component;

/**
 * <h1>Allowed Gender Validator</h1>
 *
 * @see AllowedGender
 * @see AllowedBaseOptionValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Component
public final class AllowedGenderValidator
       extends     AllowedBaseOptionValidator<Gender, AllowedGender> {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link AllowedGenderValidator}
     * with the specified {@link GenderRepositoryPort}.
     *
     * @param genderRepositoryPort The {@link Gender} repository port.
     */
    public AllowedGenderValidator(GenderRepositoryPort genderRepositoryPort) {
        super(genderRepositoryPort);
    }

}
