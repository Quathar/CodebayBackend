package com.quathar.codebay.domain.port.out.user;

import com.quathar.codebay.domain.model.Administrator;

/**
 * <h1>Administrator Repository Port</h1>
 *
 * Represents a contract for managing administrator domain models.
 *
 * @see GenericUserRepositoryPort
 * @see Administrator
 * @since 2023-12-19
 * @version 2.0
 * @author Q
 */
public interface AdministratorRepositoryPort
       extends   GenericUserRepositoryPort<Administrator, java.util.UUID> {
}
