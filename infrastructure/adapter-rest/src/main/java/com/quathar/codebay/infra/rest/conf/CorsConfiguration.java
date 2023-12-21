package com.quathar.codebay.infra.rest.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h1>CORS (Cross Origin Resource Sharing) Configuration</h1>
 * <br>
 * <p>
 *     This configuration class defines <b>Cross-Origin Resource Sharing</b> settings
 *     for allowing or restricting cross-origin requests to the API endpoints.
 * </p>
 *
 * @since 2023-12-12
 * @version 1.0
 * @author Q
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // <<-CONSTANTS->>
    /**
     * The allowed origin for CORS.
     */
    private static final String ORIGIN = "localhost:4321";

    /**
     * The header used for authorization.
     */
    private static final String AUTH_HEADER = "Authorization";

    // <<-METHOD->>
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins(ORIGIN)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders(AUTH_HEADER)
                .allowCredentials(true)
                .maxAge(3600);
    }

}
