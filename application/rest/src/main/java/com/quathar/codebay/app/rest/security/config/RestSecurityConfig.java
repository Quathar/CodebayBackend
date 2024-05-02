package com.quathar.codebay.app.rest.security.config;

import com.quathar.codebay.app.rest.security.filter.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static com.quathar.codebay.app.rest.common.api.BaseAPI.BASE_URL;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * <h1>REST (Representational State Transfer) Security Configuration</h1>
 *
 * @since 2024-03-09
 * @version 1.0
 * @author Q
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class RestSecurityConfig {

    // <<-FIELDS->>
    /**
     * The authentication provider used for authentication.
     */
    private final AuthenticationProvider authenticationProvider;
    /**
     * The JWT authentication filter used for JWT authentication.
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // <<-BEANS->>
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        // The ORDER in the filters IS IMPORTANT
        // First we configure the filters we want to disable
        return http.securityMatcher(BASE_URL + "/**")
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(configurer -> configurer.configurationSource( this.corsConfigurationSource() ))
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(STATELESS))
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var allowedOrigins = List.of("http://localhost:5173");
        // I think 'OPTION' method is not necessary here but check it later
        var allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "OPTIONS");
        var allowedHeaders = List.of("*");
//        var exposedHeaders = List.of("Authorization");

        var corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(allowedOrigins);
        corsConfig.setAllowedMethods(allowedMethods);
        corsConfig.setAllowedHeaders(allowedHeaders);
        corsConfig.setAllowCredentials(true);
//        corsConfig.setExposedHeaders(exposedHeaders);
        corsConfig.setMaxAge(3600L);

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(BASE_URL + "/**", corsConfig);
        return source;
    }

}
