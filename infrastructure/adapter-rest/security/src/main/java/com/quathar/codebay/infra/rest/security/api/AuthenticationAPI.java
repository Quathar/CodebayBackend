package com.quathar.codebay.infra.rest.security.api;

import com.quathar.codebay.infra.rest.security.annotation.AnonymousAccess;
import com.quathar.codebay.infra.rest.security.model.request.EmailAuthRequest;
import com.quathar.codebay.infra.rest.security.model.request.IdAuthenticationRequest;
import com.quathar.codebay.infra.rest.security.model.request.UsernameAuthRequest;
import com.quathar.codebay.infra.rest.security.model.response.AuthenticationResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quathar.codebay.infra.rest.common.api.BaseAPI.BASE_URL;

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
@AnonymousAccess
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
    @PostMapping(value = "/username",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    AuthenticationResponse handleUsernameAuthentication(
            @RequestBody @Valid
            UsernameAuthRequest authRequest
    );

    /**
     * Authenticate using an email address.
     *
     * @param authRequest The authentication request containing email and password.
     * @return The authentication response.
     */
    @PostMapping(value = "/email",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    AuthenticationResponse handleEmailAuthentication(
            @RequestBody @Valid
            EmailAuthRequest authRequest
    );

    /**
     * Authenticate using an ID.
     * This endpoint should not be used frequently
     *
     * @param authRequest The authentication request containing id and password.
     * @return The authentication response.
     */
    @PostMapping(value = "/id",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    AuthenticationResponse handleIdAuthentication(
            @RequestBody @Valid
            IdAuthenticationRequest authRequest
    );

}
