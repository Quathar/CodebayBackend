package com.quathar.codebay.infra.security.provider;

import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <h1>Custom DAO (Data Access Object) Authentication Provider</h1>
 *
 * This class extends Spring Security's {@link DaoAuthenticationProvider} to provide
 * custom authentication functionality using a DAO pattern for interacting with user data.
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Component
public final class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(CustomDaoAuthenticationProvider.class);

    // <<-FIELD->>
    /**
     * The user repository port.
     */
    private final UserRepositoryPort userRepositoryPort;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@code CustomDaoAuthenticationProvider}.
     *
     * @param passwordEncoder    The password encoder.
     * @param userDetailsService The user details service.
     * @param userRepositoryPort The user repository port.
     */
    @Autowired
    public CustomDaoAuthenticationProvider(
            UserRepositoryPort userRepositoryPort,
            PasswordEncoder    passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        this.userRepositoryPort = userRepositoryPort;
        super.setPasswordEncoder(passwordEncoder);
        super.setUserDetailsService(userDetailsService);
    }

    // <<-METHOD->>
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        try {
            super.additionalAuthenticationChecks(userDetails, authentication);
        } catch (BadCredentialsException exception) {
            log.debug("Updating failed authentication");
            this.userRepositoryPort.incrementFailedAuth( userDetails.getUsername() );
            throw exception;
        }
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails userDetails) {
        log.debug("Updating successful authentication");
        this.userRepositoryPort.incrementSuccessfulAuth( authentication.getName() );
        return super.createSuccessAuthentication(principal, authentication, userDetails);
    }

}
