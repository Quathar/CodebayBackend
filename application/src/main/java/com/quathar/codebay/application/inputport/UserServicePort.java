package com.quathar.codebay.application.inputport;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.usecase.user.DeleteByUsernameUseCase;
import com.quathar.codebay.domain.usecase.user.ReadByUsernameUseCase;

/**
 * <h1>User Service Port</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface UserServicePort
       extends   CrudServicePort<User, java.util.UUID>,
                 ReadByUsernameUseCase<User>,
                 DeleteByUsernameUseCase {
}
