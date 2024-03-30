package com.quathar.codebay.infra.rest.security.model.response;

/**
 * <h1>Token Pair Model</h1>
 *
 * Represents a token pair used in authentication responses.
 * This record contains the access token and refresh token included in an authentication response.
 *
 * @param accessToken  The access token used for authentication and authorization.
 * @param refreshToken The refresh token used for token refreshing.
 *
 * @since 2023-12-27
 * @version 1.0
 * @author Q
 */
public record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {}
