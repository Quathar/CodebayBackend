package com.quathar.codebay.infra.rest.conf;

import com.quathar.codebay.application.inputport.AdminServicePort;
import com.quathar.codebay.application.inputport.AuthServicePort;
import com.quathar.codebay.application.inputport.UserServicePort;
import com.quathar.codebay.application.outputport.AdminRepositoryPort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.service.AdminService;
import com.quathar.codebay.application.service.AuthService;
import com.quathar.codebay.application.service.UserService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan({
        "com.quathar.codebay.infra.jpa",
        "com.quathar.codebay.infra.memory"
})
public class InputAdapterConfiguration {

    // <<-CONSTANTS->>
    /**
     * Constant representing the qualifier for the AdminRepositoryPort bean.
     */
    private static final String ADMIN_REPOSITORY_ADAPTER = "jpaAdminRepositoryAdapter";

    // <<-BEANS->>

    /**
     * Configures the AdminServicePort using an instance of AdminRepositoryPort.
     *
     * @param adminRepositoryPort The AdminRepositoryPort implementation used by the AdminServicePort.
     * @return An instance of AdminServicePort configured with the provided AdminRepositoryPort.
     */
    @Bean
    public AdminServicePort adminServicePortInputAdapter(@Qualifier(ADMIN_REPOSITORY_ADAPTER) AdminRepositoryPort adminRepositoryPort) {
        return new AdminService(adminRepositoryPort);
    }

}
