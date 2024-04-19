package com.quathar.codebay.domain.port.out.security;

/**
 * <h1>Password Service Port</h1>
 *
 * @since 2024-04-04
 * @version 1.0
 * @author Q
 */
public interface PasswordServicePort {

    /**
     * Encodes the provided raw password.
     *
     * @param rawPassword the raw password to encode
     * @return The encoded password
     */
    String encode(CharSequence rawPassword);

    /**
     * Checks if the provided raw password matches the encoded password.
     *
     * @param rawPassword     The raw password to check
     * @param encodedPassword The encoded password to compare against
     * @return {@code true} if the raw password matches the encoded password, {@code false} otherwise
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
