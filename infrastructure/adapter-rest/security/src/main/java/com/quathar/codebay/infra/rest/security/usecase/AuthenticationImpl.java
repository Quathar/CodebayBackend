package com.quathar.codebay.infra.rest.security.usecase;

import com.quathar.codebay.application.inputport.security.JwtServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.domain.usecase.security.AuthenticationUseCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * <h1>Authentication Use Case Implementation</h1>
 *
 * @param authManagerPort The authentication manager port.
 * @param jwtServicePort  The JWT service port.
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Component
public record AuthenticationImpl(
        AuthenticationManager authManagerPort,
        JwtServicePort        jwtServicePort

) implements AuthenticationUseCase {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationImpl.class);

    // <<-METHODS->>
    @Override
    public TokenPair performAuthentication(Object authenticationKey, String password) {
        log.debug("Performing authentication");
        Authentication authToken = new UsernamePasswordAuthenticationToken(authenticationKey, password);

        // If authentication fails it throws an AuthenticationException
        Authentication validToken = this.authManagerPort.authenticate(authToken);

        log.debug("Authentication successful");

        log.debug("Generating token pair");

        return this.jwtServicePort.generateTokenPair( validToken.getName() );
    }

}
