package com.quathar.codebay.domain.exception.security;

import lombok.NoArgsConstructor;

/**
 * <h1>Not Refresh Token Exception</h1>
 *
 * Exception indicating that a specific token is not a refresh token when its required.
 *
 * @see RuntimeException
 * @since 2023-07-28
 * @version 1.0
 * @author Q
 */
@NoArgsConstructor
public class NotRefreshTokenException extends RuntimeException {
}
