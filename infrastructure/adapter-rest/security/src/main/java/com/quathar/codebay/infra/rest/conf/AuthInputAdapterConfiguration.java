package com.quathar.codebay.infra.rest.conf;

import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.outputport.AdminRepositoryPort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.service.AuthService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Authentication Input Adapter Configuration</h1>
 * <br>
 * <p>
 *     This configuration class provides methods to create and configure authentication input adapters
 *     for the application's services.
 *     Specifically, it defines a bean for the AuthServicePort to be used by the application,
 *     utilizing a UserRepositoryPort & AdminRepositoryPort implementations
 *     (jpaUserRepositoryAdapter & memoryUserRepositoryAdapter).
 * </p>
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
public class AuthInputAdapterConfiguration {

    // <<-CONSTANTS->>
    /**
     * Constant representing the qualifier for the AdminRepositoryPort bean.
     */
    private static final String ADMIN_REPOSITORY_ADAPTER = "jpaAdminRepositoryAdapter";
    /**
     * Constant representing the qualifier for the UserRepositoryPort bean.
     */
    private static final String USER_REPOSITORY_ADAPTER = "jpaUserRepositoryAdapter";

    // <<-BEANS->>
    /**
     * Bean configuration method to instantiate the AuthServicePort.
     *
     * @param adminRepositoryPort The AdminRepositoryPort implementation retrieved by qualifier.
     * @param userRepositoryPort  The UserRepositoryPort implementation retrieved by qualifier.
     * @return An instance of AuthServicePort for handling authentication-related operations.
     */
    @Bean
    public AuthServicePort authServicePortInputAdapter(
            @Qualifier(ADMIN_REPOSITORY_ADAPTER) AdminRepositoryPort adminRepositoryPort,
            @Qualifier(USER_REPOSITORY_ADAPTER)  UserRepositoryPort userRepositoryPort
    ) {
        return new AuthService(adminRepositoryPort, userRepositoryPort);
    }

}
