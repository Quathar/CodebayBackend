package com.quathar.codebay.infra.security.adapter;

import com.quathar.codebay.domain.port.out.security.AuthenticationManagerPort;
import com.quathar.codebay.domain.port.out.security.TokenServicePort;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Map;

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
@Slf4j
@Component
@AllArgsConstructor
public class AuthenticationManagerAdapter implements AuthenticationManagerPort {

    // <<-CONSTANTS->>
    /**
     * Prefix used for role-based authorities.
     */
    private static final String ROLE_PREFIX = "ROLE_";

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
    /**
     * Generates additional custom claims based on the provided valid authentication token.
     *
     * @param validToken The valid authentication token.
     * @return A {@link Map} containing the additional custom claims.
     */
    private Map<String, ?> generateExtraClaims(Authentication validToken) {
        log.info("Generating extra claims");
        String role = validToken.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.startsWith(ROLE_PREFIX))
                .findFirst()
                .get()
                .substring(ROLE_PREFIX.length());
        return Map.of("role", role);
    }

    @Override
    public TokenPair performAuthentication(String authenticationKey, String password) {
        log.info("Performing authentication");
        Authentication authToken = new UsernamePasswordAuthenticationToken(authenticationKey, password);

        // If authentication fails it throws an AuthenticationException
        Authentication validToken = this.authenticationManager.authenticate(authToken);

        log.info("Authentication successful");
        return this.tokenServicePort.generateTokenPair( validToken.getName(), this.generateExtraClaims(validToken) );
    }

    @Override
    public TokenPair performRefresh(String token) {
        log.info("Performing refresh");
        return this.tokenServicePort.refresh(token);
    }

}
