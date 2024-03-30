package com.quathar.codebay.infra.rest.security.controller;

import com.quathar.codebay.application.inputport.security.AuthenticationServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.infra.rest.security.api.AuthenticationAPI;
import com.quathar.codebay.infra.rest.security.factory.HttpSecurityFactory;
import com.quathar.codebay.infra.rest.security.model.request.EmailAuthRequest;
import com.quathar.codebay.infra.rest.security.model.request.IdAuthenticationRequest;
import com.quathar.codebay.infra.rest.security.model.request.UsernameAuthRequest;
import com.quathar.codebay.infra.rest.security.model.response.AuthenticationResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Authentication Controller</h1>
 *
 * Controller for handling authentication requests.
 * <br/>
 * This controller provides endpoints for authenticating users using different credentials such as username, email, and ID.
 *
 * @see AuthenticationAPI
 * @see AuthenticationServicePort
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@RestController
public class AuthenticationController implements AuthenticationAPI {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    // <<-FIELD->>
    /**
     * The port for authentication service.
     */
    private final AuthenticationServicePort authServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs an AuthenticationController with the specified AuthenticationServicePort.
     *
     * @param authServicePort The port for authentication service.
     */
    @Autowired
    public AuthenticationController(AuthenticationServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    // <<-METHODS->>
    private AuthenticationResponse handleAuthentication(Object authenticationKey, String password) {
        log.debug("Handling authentication request in handleAuthentication method");

        TokenPair tokenPair = this.authServicePort.performAuthentication(authenticationKey, password);

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
        return this.handleAuthentication( authRequest.id(), authRequest.password() );
    }

}
