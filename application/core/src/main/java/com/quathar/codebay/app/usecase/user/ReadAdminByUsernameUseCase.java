package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.exception.ModelNotFoundException;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.in.user.ReadByUsernameUseCasePort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * <h1>Read Administrator by Username Use Case Implementation</h1>
 *
 * @see ReadByUsernameUseCasePort
 * @see Administrator
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
public final class ReadAdminByUsernameUseCase implements ReadByUsernameUseCasePort<Administrator> {

    // <<-FIELD->>
    /**
     * The administrator repository port.
     */
    @NonNull
    private final AdministratorRepositoryPort adminRepositoryPort;

    // <<-METHOD->>
    @Override
    public Administrator getByUsername(String username) {
        return this.adminRepositoryPort
                .findByUsername(username)
                .orElseThrow(ModelNotFoundException::new);
    }

}
