package com.quathar.codebay.application.inputport;

import com.quathar.codebay.application.usecase.LoginAdminUseCase;
import com.quathar.codebay.application.usecase.LoginUserUseCase;

/**
 * <h1>Authentication Service Port</h1>
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface AuthServicePort extends LoginAdminUseCase, LoginUserUseCase {
}
