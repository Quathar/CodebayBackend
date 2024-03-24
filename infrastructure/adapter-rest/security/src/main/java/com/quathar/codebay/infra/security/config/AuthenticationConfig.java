package com.quathar.codebay.infra.security.config;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.domain.exception.InvalidCredentialsException;
import com.quathar.codebay.infra.security.factory.HttpSecurityFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <h1>Authentication Configuration</h1>
 *
 * Configuration class for setting up authentication and related beans
 * in the Spring Security framework.<br/>
 * <br/>
 * This class defines beans for configuring authentication manager, user details service,
 * password encoder, and authentication provider.
 *
 * @since 2024-03-10
 * @version 1.0
 * @author Q
 */
@Configuration
public class AuthenticationConfig {

    // <<-BEANS->>
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // Here ProviderManager that implements AuthenticationManager is returned
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepositoryPort userRepositoryPort) {
        return (authKey) -> userRepositoryPort.findByAuthenticationKey(authKey)
                .map(HttpSecurityFactory.getUserDetails()::fromModel)
                .orElseThrow(InvalidCredentialsException::new);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsService userDetailsService,
            PasswordEncoder    passwordEncoder
    ) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder   (passwordEncoder);
        return authenticationProvider;
    }

}
