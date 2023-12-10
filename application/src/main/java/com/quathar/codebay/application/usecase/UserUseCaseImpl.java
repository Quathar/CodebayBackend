package com.quathar.codebay.application.usecase;

import com.quathar.codebay.application.inputport.UserUseCase;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.model.User;

import java.util.UUID;

/**
 * <h1>User Use Case Implementation</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public class UserUseCaseImpl extends CrudUseCaseImpl<User, UUID> implements UserUseCase {

    // <<-FIELD->>
    private final UserRepositoryPort userRepositoryPort;

    // <<-CONSTRUCTOR->>
    public UserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
    }

}
