package com.quathar.codebay.app.rest.security.controller;

import com.quathar.codebay.app.rest.security.api.AuthenticationAPI;
import com.quathar.codebay.app.rest.security.model.factory.HttpSecurityFactory;
import com.quathar.codebay.app.rest.security.model.request.authentication.EmailAuthRequest;
import com.quathar.codebay.app.rest.security.model.request.authentication.IdAuthenticationRequest;
import com.quathar.codebay.app.rest.security.model.request.authentication.UsernameAuthRequest;
import com.quathar.codebay.app.rest.security.model.response.AuthenticationResponse;
import com.quathar.codebay.app.service.security.AuthenticationService;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Authentication Controller</h1>
 *
 * Controller for handling authentication requests.
 * <br/>
 * This controller provides endpoints for authenticating users using different credentials such as username, email, and ID.
 *
 * @see AuthenticationAPI
 * @see AuthenticationService
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@RestController
@AllArgsConstructor
public class AuthenticationController implements AuthenticationAPI {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    // <<-FIELD->>
    /**
     * The port for authentication service.
     */
    private final AuthenticationService authService;

    // <<-METHODS->>
    /**
     * Handles authentication based on the provided authentication key and password.
     *
     * @param authenticationKey The authentication key (e.g., username, email, ID).
     * @param password          The password associated with the authentication key.
     * @return An AuthenticationResponse object containing authentication tokens.
     */
    private AuthenticationResponse handleAuthentication(String authenticationKey, String password) {
        log.debug("Handling authentication request in handleAuthentication method");

        TokenPair tokenPair = this.authService.authenticate(authenticationKey, password);

        log.debug("Authentication successful. Returning 200 OK status");

        return HttpSecurityFactory.getAuthenticationResponse().fromModel(tokenPair);
    }

    @Override
    public AuthenticationResponse handleUsernameAuthentication(UsernameAuthRequest authRequest) {
        log.debug("Handling username authentication request");
        return this.handleAuthentication( authRequest.username(), authRequest.password() );
    }

    @Override
    public AuthenticationResponse handleEmailAuthentication(EmailAuthRequest authRequest) {
        log.debug("Handling email authentication request");
        return this.handleAuthentication( authRequest.email(), authRequest.password() );
    }

    @Override
    public AuthenticationResponse handleIdAuthentication(IdAuthenticationRequest authRequest) {
        log.debug("Handling id authentication request");
        return this.handleAuthentication( authRequest.id().toString(), authRequest.password() );
    }

}
