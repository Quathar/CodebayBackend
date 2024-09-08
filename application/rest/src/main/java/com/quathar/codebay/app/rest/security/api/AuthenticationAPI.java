package com.quathar.codebay.app.rest.security.api;

import com.quathar.codebay.app.rest.security.model.request.authentication.EmailAuthRequest;
import com.quathar.codebay.app.rest.security.model.request.authentication.IdAuthenticationRequest;
import com.quathar.codebay.app.rest.security.model.request.authentication.UsernameAuthRequest;
import com.quathar.codebay.app.rest.security.model.response.AuthenticationResponse;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <h1>Authentication API</h1>
 *
 * This interface defines methods for authenticating users via different credentials.
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@RequestMapping(AuthenticationAPI.ROOT)
@PreAuthorize("isAnonymous()")
public interface AuthenticationAPI {

    // <<-CONSTANT->>
    /**
     * The root path for authentication API.
     */
    String ROOT = BASE_URL + "/auth";

    // <<-METHODS->>
    /**
     * Authenticate using a username.
     *
     * @param authRequest The authentication request containing username and password.
     * @return The authentication response.
     */
    @PostMapping(path = "/username",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    AuthenticationResponse handleUsernameAuthentication(
            @Valid @RequestBody
            UsernameAuthRequest authRequest
    );

    /**
     * Authenticate using an email address.
     *
     * @param authRequest The authentication request containing email and password.
     * @return The authentication response.
     */
    @PostMapping(path = "/email",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    AuthenticationResponse handleEmailAuthentication(
            @Valid @RequestBody
            EmailAuthRequest authRequest
    );

    /**
     * Authenticate using an ID.
     * This endpoint should not be used frequently
     *
     * @param authRequest The authentication request containing id and password.
     * @return The authentication response.
     */
    @PostMapping(path = "/id",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    AuthenticationResponse handleIdAuthentication(
            @Valid @RequestBody
            IdAuthenticationRequest authRequest
    );

    /**
     * Refreshes the authentication tokens based on the provided refresh token.
     *
     * @return The authentication response.
     */
    @PostMapping(path = "/refresh-token", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('REFRESH_MY_TOKENS')")
    @ResponseStatus(OK)
    AuthenticationResponse handleTokenRefresh();

}
