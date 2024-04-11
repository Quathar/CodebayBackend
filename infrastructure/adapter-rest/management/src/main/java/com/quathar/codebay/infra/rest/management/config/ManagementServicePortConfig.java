package com.quathar.codebay.infra.rest.management.config;

import com.quathar.codebay.application.inputport.AdministratorServicePort;
import com.quathar.codebay.application.outputport.AdministratorRepositoryPort;
import com.quathar.codebay.application.service.user.AdministratorService;
import com.quathar.codebay.application.usecase.crud.CreateModelImpl;
import com.quathar.codebay.application.usecase.crud.DeleteModelImpl;
import com.quathar.codebay.application.usecase.crud.ReadAllModelsImpl;
import com.quathar.codebay.application.usecase.crud.ReadModelImpl;
import com.quathar.codebay.application.usecase.crud.UpdateModelImpl;
import com.quathar.codebay.application.usecase.user.DeleteAdministratorByUsername;
import com.quathar.codebay.application.usecase.user.ReadAdministratorByUsername;

import org.springframework.context.annotation.Bean;

/**
 * <h1>Management Service Port Configuration</h1>
 *
 * @version 1.0
 * @author Q
 */
public class ManagementServicePortConfig {

    @Bean
    public AdministratorServicePort administratorServicePort(AdministratorRepositoryPort repositoryPort) {
        return AdministratorService.setup()
                .readAllUseCase( new ReadAllModelsImpl<>(repositoryPort) )
                .readUseCase( new ReadModelImpl<>(repositoryPort) )
                .readByUsernameUseCase( new ReadAdministratorByUsername(repositoryPort) )
                .createUseCase( new CreateModelImpl<>(repositoryPort) )
                .updateUseCase( new UpdateModelImpl<>(repositoryPort) )
                .deleteUseCase( new DeleteModelImpl<>(repositoryPort) )
                .deleteByUsernameUseCase( new DeleteAdministratorByUsername(repositoryPort) )
                .seal();
    }

}
