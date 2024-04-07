package com.quathar.codebay.application.inputport;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.user.DeleteByUsernameUseCase;
import com.quathar.codebay.domain.usecase.user.ReadByUsernameUseCase;

/**
 * <h1>Administrator Service Port</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface AdministratorServicePort
       extends   CrudServicePort<Administrator, java.util.UUID>,
                 ReadByUsernameUseCase<Administrator>,
                 DeleteByUsernameUseCase {
}
