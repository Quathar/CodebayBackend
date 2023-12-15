package com.quathar.codebay.infra.inputadapter.conf;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.service.AuthService;
import com.quathar.codebay.application.service.UserService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Input Adapter Configuration</h1>
 * <br>
 * <p>
 *     This configuration class provides methods to create and configure input adapters
 *     for the application's services.
 *     Specifically, it defines a bean for the UserServicePort to be used by the application,
 *     utilizing a UserRepositoryPort implementation (memoryUserRepositoryAdapter in this case)
 *     to interact with user data.
 * </p>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Configuration
public class InputAdapterConfiguration {

    // <<-CONSTANTS->>
    /**
     * Constant representing the qualifier for the UserRepositoryPort bean.
     */
    private static final String USER_REPOSITORY_ADAPTER = "jpaUserRepositoryAdapter";

    // <<-BEANS->>
    /**
     * Bean configuration method to instantiate the AuthServicePort.
     *
     * @param userRepositoryPort The UserRepositoryPort implementation retrieved by qualifier.
     * @return An instance of AuthServicePort for handling authentication-related operations.
     */
    @Bean
    public AuthServicePort authServicePortInputAdapter(@Qualifier(USER_REPOSITORY_ADAPTER) UserRepositoryPort userRepositoryPort) {
        return new AuthService(userRepositoryPort);
    }

    /**
     * Configures the UserServicePort using an instance of UserRepositoryPort.
     *
     * @param userRepositoryPort The UserRepositoryPort implementation used by the UserServicePort.
     * @return An instance of UserServicePort configured with the provided UserRepositoryPort.
     */
    @Bean
    public UserServicePort userServicePortInputAdapter(@Qualifier(USER_REPOSITORY_ADAPTER) UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }

}
