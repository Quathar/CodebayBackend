package com.quathar.codebay.infra.security.adapter;

import com.quathar.codebay.domain.port.out.security.PasswordServicePort;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <h1>Password Service Adapter</h1>
 *
 * @see PasswordServicePort
 * @see PasswordEncoder
 * @since 2024-03-XX
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class PasswordServiceAdapter implements PasswordServicePort {

    // <<-FIELD->>
    /**
     * The spring security PasswordEncoder.
     */
    private final PasswordEncoder passwordEncoder;

    // <<-METHODS->>
    @Override
    public String encode(CharSequence rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
