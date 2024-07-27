package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedUserStatus;
import com.quathar.codebay.domain.port.out.option.UserStatusRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.UserStatus;

import org.springframework.stereotype.Component;

/**
 * <h1>Allowed User Status Validator</h1>
 *
 * @see AllowedUserStatus
 * @see AllowedBaseOptionValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Component
public final class AllowedUserStatusValidator
       extends     AllowedBaseOptionValidator<UserStatus, AllowedUserStatus>{

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link AllowedUserStatusValidator}
     * with the specified {@link UserStatusRepositoryPort}.
     *
     * @param userStatusRepositoryPort The {@link UserStatus} repository port.
     */
    public AllowedUserStatusValidator(UserStatusRepositoryPort userStatusRepositoryPort) {
        super(userStatusRepositoryPort);
    }

}
