package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.outputport.AdministratorRepositoryPort;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.user.ReadByUsernameUseCase;

/**
 * <h1>Read Administrator by Username Use Case Implementation</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public record ReadAdministratorByUsername(AdministratorRepositoryPort adminRepositoryPort) implements ReadByUsernameUseCase<Administrator> {

    @Override
    public Administrator getByUsername(String username) {
        return this.adminRepositoryPort
                .findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
