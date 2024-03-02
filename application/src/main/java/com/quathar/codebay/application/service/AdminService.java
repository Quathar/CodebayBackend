package com.quathar.codebay.application.service;

import com.quathar.codebay.application.inputport.AdminServicePort;
import com.quathar.codebay.application.outputport.AdminRepositoryPort;
import com.quathar.codebay.application.util.HashManager;
import com.quathar.codebay.application.util.TokenManager;
import com.quathar.codebay.domain.exception.ResourceNotFoundException;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.enumerator.UserStatus;

import java.util.UUID;

/**
 * <h1>Admin Service</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
public class      AdminService
       extends    CrudService<Administrator, UUID>
       implements AdminServicePort {

    // <<-FIELD->>
    private final AdminRepositoryPort adminRepositoryPort;

    // <<-CONSTRUCTOR->>
    public AdminService(AdminRepositoryPort adminRepositoryPort) {
        super(adminRepositoryPort);
        this.adminRepositoryPort = adminRepositoryPort;
    }

    // <<-METHODS->>
    @Override
    public Administrator getByToken(String token) throws ResourceNotFoundException {
        UUID id = UUID.fromString(TokenManager.getSubject(token));
        return this.adminRepositoryPort.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Administrator create(Administrator user) {
        String password = user.getPassword();
        user.setPassword(HashManager.hash(password));
        user.setStatus(UserStatus.ACTIVE);
        user.setSuccessfulAuth(0);
        user.setFailedAuth(0);
        return this.adminRepositoryPort.save(user);
    }

}
