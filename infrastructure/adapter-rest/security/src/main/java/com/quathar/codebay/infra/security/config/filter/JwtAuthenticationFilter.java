package com.quathar.codebay.infra.security.config.filter;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.inputport.security.JwtServicePort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.security.factory.HttpSecurityFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final JwtServicePort jwtServicePort;
    /**
     * The service port for user operations.
     */
    private final UserServicePort userServicePort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a JwtAuthenticationFilter with the specified JwtServicePort and UserServicePort.
     *
     * @param jwtServicePort The service port for JWT operations.
     * @param userServicePort The service port for user operations.
     */
    @Autowired
    public JwtAuthenticationFilter(
            JwtServicePort  jwtServicePort,
            UserServicePort userServicePort
    ) {
        this.jwtServicePort  = jwtServicePort;
        this.userServicePort = userServicePort;
    }

    // <<-METHOD->>
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
        String username = this.jwtServicePort.extractUsername(jwtToken);

        // 4. Set an Authentication object inside the SecurityContextHolder
        User user = this.userServicePort.getByUsername(username);
        UserDetails userDetails = HttpSecurityFactory.getUserDetails().fromModel(user);

        Authentication authToken = new UsernamePasswordAuthenticationToken(
                username,
                null,
                userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
        log.debug("Authenticated user: {}", username);

        // 5. Execute all other filters
        log.debug("Continue with other filters");
        filterChain.doFilter(request, response);
    }

}
