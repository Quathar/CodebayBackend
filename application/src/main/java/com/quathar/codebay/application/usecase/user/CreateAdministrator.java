package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.outputport.AdministratorRepositoryPort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.crud.CreateModelUseCase;

/**
 * <h1>Create Administrator Use Case Implementation</h1>
 *
 * @param adminRepositoryPort
 *
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
public record CreateAdministrator(AdministratorRepositoryPort adminRepositoryPort) implements CreateModelUseCase<Administrator> {

    // <<-METHODS->>
    private Administrator initialize(Administrator adminToRegister) {
        return null;
    }

    @Override
    public Administrator create(Administrator adminToRegister) {
        Administrator initialized = this.initialize(adminToRegister);
        return this.adminRepositoryPort.save(initialized);
    }

}
