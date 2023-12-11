package com.quathar.codebay.application.outputport;

import com.quathar.codebay.domain.model.User;

import java.util.UUID;

/**
 * <h1>User Repository Port</h1>
 * <br>
 * <p>
 *     Represents a contract for managing User domain models.
 * </p>
 *
 * @since 2023-12-10
 * @version 2.0
 * @author Q
 */
public interface UserRepositoryPort extends CrudRepositoryPort<User, UUID> {
}
