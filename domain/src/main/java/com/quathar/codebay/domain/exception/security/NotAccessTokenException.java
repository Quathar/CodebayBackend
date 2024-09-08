package com.quathar.codebay.domain.exception.security;

import lombok.NoArgsConstructor;

/**
 * <h1>Not Access Token Exception</h1>
 *
 * Exception indicating that a specific token is not an access token when its required.
 *
 * @see RuntimeException
 * @since 2023-07-28
 * @version 1.0
 * @author Q
 */
@NoArgsConstructor
public class NotAccessTokenException extends RuntimeException {
}
