package com.quathar.codebay.application.inputport.security;

import com.quathar.codebay.domain.usecase.security.token.ExtractUsernameUseCase;
import com.quathar.codebay.domain.usecase.security.token.GenerateTokenPairUseCase;

/**
 * <h1>JWT (JSON Web Token) Service Port</h1>
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
public interface JwtServicePort extends GenerateTokenPairUseCase, ExtractUsernameUseCase {
}
