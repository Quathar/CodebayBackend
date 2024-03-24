package com.quathar.codebay.infra.rest.common.config;

import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Common Input Adapter Configuration</h1>
 *
 * This configuration class provides methods to create
 * and configure common input adapters for the application services.
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Configuration
@ComponentScan({
        "com.quathar.codebay.infra.jpa",
        "com.quathar.codebay.infra.memory"
})
public class CommonInputAdapterConfig {

    // <<-BEANS->>
    /**
     * Configures the UserServicePort using an instance of UserRepositoryPort.
     *
     * @param userRepositoryPort The UserRepositoryPort implementation used by the UserServicePort.
     * @return An instance of {@link UserServicePort} configured with the provided {@link UserRepositoryPort}.
     */
    @Bean
    public UserServicePort userServicePortInputAdapter(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }

}
