package com.quathar.codebay.infra.rest.security.config;

import com.quathar.codebay.infra.rest.security.config.filter.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static com.quathar.codebay.infra.rest.common.api.BaseAPI.BASE_URL;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Security Configuration</h1>
 *
 * @since 2024-03-09
 * @version 1.0
 * @author Q
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {

    // <<-CONSTANTS->>
    /**
     * The allowed origin for CORS.
     */
    private static final List<String> ALLOWED_ORIGINS = List.of("http://localhost:5173");
    /**
     * The header used for authorization.
     */
    private static final String AUTH_HEADER = "Authorization";

    // <<-FIELDS->>
    /**
     * The authentication provider used for authentication.
     */
    private final AuthenticationProvider authenticationProvider;
    /**
     * The JWT authentication filter used for JWT authentication.
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // <<-CONSTRUCTOR->>
    /**
     *  Constructs an instance of {@code HttpSecurityConfig} with the specified authentication provider and JWT authentication filter.
     *
     * @param authenticationProvider  The authentication provider.
     * @param jwtAuthenticationFilter The JWT authentication filter.
     */
    @Autowired
    public HttpSecurityConfig(
            AuthenticationProvider  authenticationProvider,
            JwtAuthenticationFilter jwtAuthenticationFilter
    ) {
        this.authenticationProvider  = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // <<-BEANS->>
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        // The ORDER in the filters IS IMPORTANT
        // First we configure the filters we want to disable
        return http.securityMatcher(BASE_URL)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(configurer -> configurer.configurationSource(this.corsConfigurationSource()))
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        // I think 'OPTION' method is not necessary here but check it later
        List<String> allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "OPTIONS");
        List<String> allowedHeaders = List.of("*");
//        List<String> exposedHeaders = List.of(AUTH_HEADER);

        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(ALLOWED_ORIGINS);
        corsConfig.setAllowedMethods(allowedMethods);
        corsConfig.setAllowedHeaders(allowedHeaders);
        corsConfig.setAllowCredentials(true);
//        corsConfig.setExposedHeaders(exposedHeaders);
        corsConfig.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(BASE_URL + "/**", corsConfig);
        return source;
    }

}
