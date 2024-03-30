package com.quathar.codebay.infra.rest.security.adapter;

import com.quathar.codebay.application.inputport.security.AuthenticationServicePort;
import com.quathar.codebay.application.inputport.security.JwtServicePort;
import com.quathar.codebay.domain.model.security.TokenPair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <h1>Authentication Service</h1>
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Service
public class AuthenticationServiceAdapter implements AuthenticationServicePort {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceAdapter.class);

    // <<-FIELDS->>
    /**
     * The authentication manager port.
     */
    private final AuthenticationManager authManagerPort;
    /**
     * The JWT service port.
     */
    private final JwtServicePort jwtServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code AuthenticationServiceAdapter}.
     *
     * @param authManagerPort The authentication manager port.
     * @param jwtServicePort  The JWT service port.
     */
    @Autowired
    public AuthenticationServiceAdapter(AuthenticationManager authManagerPort, JwtServicePort jwtServicePort) {
        this.authManagerPort = authManagerPort;
        this.jwtServicePort  = jwtServicePort;
    }

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
