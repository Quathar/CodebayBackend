package com.quathar.codebay.domain.usecase.security;

/**
 * <h1>Encode Password Use Case</h1>
 *
 * @since 2024-04-04
 * @version 1.0
 * @author Q
 */
public interface EncodePasswordUseCase {

    /**
     * Encodes the provided raw password.
     *
     * @param rawPassword the raw password to encode
     * @return The encoded password
     */
    String encode(CharSequence rawPassword);

}
