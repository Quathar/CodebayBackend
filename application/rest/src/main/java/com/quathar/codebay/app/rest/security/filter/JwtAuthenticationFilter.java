package com.quathar.codebay.app.rest.security.filter;

import com.quathar.codebay.app.service.user.UserService;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.port.out.security.TokenServicePort;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * <h1>JWT (JSON Web Token) Authentication Filter</h1>
 *
 * Filter responsible for JWT authentication.
 * <br/>
 * PD: Just think, why not use an AuthenticationProvider implementation
 * (for example, called JwtAuthenticationProvider)?
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    // <<-CONSTANT->>
    /**
     * The name of the authorization header.
     */
    private static final String AUTHORIZATION_HEADER = "Authorization";
    /**
     * The prefix for the Bearer token in the authorization header.
     */
    private static final String BEARER_PREFIX = "Bearer ";

    // <<-FIELDS->>
    /**
     * The service port for JWT operations.
     */
    private final TokenServicePort jwtService;
    /**
     * The service port for user operations.
     */
    private final UserService userService;

    // <<-METHODS->>
    /**
     * Sets the Authentication object inside the SecurityContextHolder based on the provided username.
     *
     * @param username The username of the authenticated user.
     */
    private void setSecurityContextHolder(String username) {
        var role = this.userService
                .getByUsername(username)
                .getRole();
        var authorities = role.getGrantedPermissions()
                .map(GrantedPermission::getOperation)
                .map(Operation::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(java.util.stream.Collectors.toSet());
        var roleAuthority = new SimpleGrantedAuthority( "ROLE_" + role.getName() );
        authorities.add(roleAuthority);
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                username,
                null,
                authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest  request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain         filterChain
    ) throws ServletException, IOException {
        log.debug("JWT Authentication Filter is processing");

        // 1. Get the header that contains the JWT (JSON Web Token)
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader == null || !authorizationHeader.startsWith(BEARER_PREFIX)) {
            log.debug("JWT Authentication failed. Continue with other filters");
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Get the JWT token
        String jwtToken = authorizationHeader.substring(BEARER_PREFIX.length()).trim();

        // 3. Get 'subject/username' from JWT
        log.debug("Extracting <username> from the JWT");
        String username = this.jwtService.extractUsername(jwtToken);

        // 4. Set an Authentication object inside the SecurityContextHolder
        this.setSecurityContextHolder(username);
        log.debug("Authenticated user: {}", username);

        // 5. Execute all other filters
        log.debug("Continue with other filters");
        filterChain.doFilter(request, response);
    }

}
