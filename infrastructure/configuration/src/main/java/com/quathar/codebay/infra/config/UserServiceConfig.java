package com.quathar.codebay.infra.config;

import com.quathar.codebay.app.service.user.AdministratorService;
import com.quathar.codebay.app.service.user.CustomerService;
import com.quathar.codebay.app.service.user.UserService;
import com.quathar.codebay.app.usecase.DeleteModelUseCase;
import com.quathar.codebay.app.usecase.ReadAllModelsUseCase;
import com.quathar.codebay.app.usecase.ReadModelUseCase;
import com.quathar.codebay.app.usecase.UpdateModelUseCase;
import com.quathar.codebay.app.usecase.user.CreateAdminUseCase;
import com.quathar.codebay.app.usecase.user.CreateCustomerUseCase;
import com.quathar.codebay.app.usecase.user.CreateUserUseCase;
import com.quathar.codebay.app.usecase.user.DeleteAbstractUserByIdUseCase;
import com.quathar.codebay.app.usecase.user.DeleteAbstractUserByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.ReadAbstractUserByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.UpdateAdminByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.UpdateCustomerByUsernameUseCase;
import com.quathar.codebay.app.usecase.user.UpdateUserByUsernameUseCase;
import com.quathar.codebay.domain.port.out.shop.ShoppingCartRepositoryPort;
import com.quathar.codebay.domain.port.out.shop.WishListRepositoryPort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.domain.port.out.user.CustomerRepositoryPort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>User Service Configuration</h1>
 *
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
@Configuration
public class UserServiceConfig {

    @Bean
    public UserService userService(
            UserRepositoryPort  userRepository,
            RoleRepositoryPort  roleRepository,
            PasswordServicePort passwordService
    ) {
        return UserService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(userRepository) )
                .readUseCase( new ReadModelUseCase<>(userRepository) )
                .readByUsernameUseCase( new ReadAbstractUserByUsernameUseCase<>(userRepository) )
                .createUseCase( new CreateUserUseCase(userRepository, roleRepository, passwordService) )
                .updateUseCase( new UpdateModelUseCase<>(userRepository) )
                .updateByUsernameUseCase( new UpdateUserByUsernameUseCase(userRepository) )
                .deleteUseCase( new DeleteModelUseCase<>(userRepository) )
                .deleteByUsernameUseCase( new DeleteAbstractUserByUsernameUseCase<>(userRepository) )
                .seal();
    }

    @Bean
    public AdministratorService adminService(
            AdministratorRepositoryPort adminRepository,
            RoleRepositoryPort          roleRepository,
            PasswordServicePort         passwordService
    ) {
        return AdministratorService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(adminRepository) )
                .readUseCase( new ReadModelUseCase<>(adminRepository) )
                .readByUsernameUseCase( new ReadAbstractUserByUsernameUseCase<>(adminRepository) )
                .createUseCase( new CreateAdminUseCase(adminRepository, roleRepository, passwordService) )
                .updateUseCase( new UpdateModelUseCase<>(adminRepository) )
                .updateByUsernameUseCase( new UpdateAdminByUsernameUseCase(adminRepository) )
                .deleteUseCase( new DeleteAbstractUserByIdUseCase<>(adminRepository) )
                .deleteByUsernameUseCase( new DeleteAbstractUserByUsernameUseCase<>(adminRepository) )
                .seal();
    }

    @Bean
    public CustomerService customerService(
            CustomerRepositoryPort     customerRepository,
            ShoppingCartRepositoryPort cartRepository,
            WishListRepositoryPort     wishListRepository,
            RoleRepositoryPort         roleRepository
    ) {
        return CustomerService.setup()
                .readAllUseCase( new ReadAllModelsUseCase<>(customerRepository) )
                .readUseCase( new ReadModelUseCase<>(customerRepository) )
                .readByUsernameUseCase( new ReadAbstractUserByUsernameUseCase<>(customerRepository) )
                .createUseCase( new CreateCustomerUseCase(customerRepository, cartRepository, wishListRepository, roleRepository) )
                .updateUseCase( new UpdateModelUseCase<>(customerRepository) )
                .updateByUsernameUseCase( new UpdateCustomerByUsernameUseCase(customerRepository) )
                .deleteUseCase( new DeleteModelUseCase<>(customerRepository) )
                .deleteByUsernameUseCase( new DeleteAbstractUserByUsernameUseCase<>(customerRepository) )
                .seal();
    }

}
