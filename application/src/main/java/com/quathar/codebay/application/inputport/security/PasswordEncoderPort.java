package com.quathar.codebay.application.inputport.security;

import com.quathar.codebay.domain.usecase.security.EncodePasswordUseCase;
import com.quathar.codebay.domain.usecase.security.PasswordMatchesUseCase;

/**
 * <h1>Password Encoder Port</h1>
 *
 * @since 2024-04-04
 * @version 1.0
 * @author Q
 */
public interface PasswordEncoderPort extends EncodePasswordUseCase, PasswordMatchesUseCase {
}
