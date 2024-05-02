package com.quathar.codebay.infra.security.adapter;

import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;
import com.quathar.codebay.domain.port.out.security.TokenServicePort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * <h1>Authentication Manager Adapter</h1>
 *
 * @see AuthenticationManagerPort
 * @see AuthenticationManager
 * @see TokenServicePort
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class AuthenticationManagerAdapter implements AuthenticationManagerPort {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationManagerAdapter.class);

    // <<-FIELDS->>
    /**
     * The spring security AuthenticationManager.
     */
    private final AuthenticationManager authenticationManager;
    /**
     * The port for token service.
     */
    private final TokenServicePort tokenServicePort;

    // <<-METHOD->>
    @Override
    public TokenPair performAuthentication(String authenticationKey, String password) {
        log.debug("Performing authentication");
        Authentication authToken = new UsernamePasswordAuthenticationToken(authenticationKey, password);

        // If authentication fails it throws an AuthenticationException
        Authentication validToken = this.authenticationManager.authenticate(authToken);

        log.debug("Authentication successful");

        log.debug("Generating token pair");

        return this.tokenServicePort.generateTokenPair( validToken.getName() );
    }

}
