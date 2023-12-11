package com.quathar.codebay.infra.inputadapter.conf;

import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.inputport.UserUseCase;
import com.quathar.codebay.application.service.UserService;
import com.quathar.codebay.application.usecase.UserUseCaseImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>Input Adapter Configuration</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Configuration
public class InputAdapterConfiguration {

    @Bean
    public UserService applicationUserUseCase(UserUseCase userUseCase) {
        return new UserService(userUseCase);
    }

    @Bean
    public UserUseCase applicationUserUseCase(UserRepositoryPort userRepositoryPort) {
        return new UserUseCaseImpl(userRepositoryPort);
    }

}
