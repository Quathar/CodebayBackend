package com.quathar.codebay.application.inputport;

import com.quathar.codebay.application.inputport.crud.CrudUseCase;
import com.quathar.codebay.domain.model.User;

import java.util.UUID;

/**
 * <h1>User Use Cases</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface UserUseCase extends CrudUseCase<User, UUID> {
}
