package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.ReadByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.AbstractUserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read abstract user by username Use Case Implementation</h1>
 *
 * @param <M> The type of abstract user
 *
 * @see ReadByUsernameUseCasePort
 * @see User
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
@AllArgsConstructor
public class ReadAbstractUserByUsernameUseCase<M extends User> implements ReadByUsernameUseCasePort<M> {

    // <<-FIELD->>
    /**
     * The abstract user repository port.
     */
    @NonNull
    private final AbstractUserRepositoryPort<M, ?> abstractUserRepositoryPort;

    // <<-METHOD->>
    @Override
    public M getByUsername(String username) {
        return this.abstractUserRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
    }

}
