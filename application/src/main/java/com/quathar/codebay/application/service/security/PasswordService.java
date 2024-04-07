package com.quathar.codebay.application.service.security;

import com.quathar.codebay.application.inputport.security.PasswordServicePort;
import com.quathar.codebay.domain.usecase.security.EncodePasswordUseCase;
import com.quathar.codebay.domain.usecase.security.PasswordMatchesUseCase;

import lombok.Builder;
import lombok.NonNull;

/**
 * <h1>Password Service</h1>
 *
 * @since 2024-04-04
 * @version 1.0
 * @author Q
 */
@Builder(builderMethodName = "setup", buildMethodName = "seal")
public class PasswordService implements PasswordServicePort {

    // <<-FIELDS->>
    @NonNull private final EncodePasswordUseCase  encodeUseCase;
    @NonNull private final PasswordMatchesUseCase matchesUseCase;

    // <<-METHODS->>
    @Override
    public String encode(CharSequence rawPassword) {
        return this.encodeUseCase.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.matchesUseCase.matches(rawPassword, encodedPassword);
    }

}
