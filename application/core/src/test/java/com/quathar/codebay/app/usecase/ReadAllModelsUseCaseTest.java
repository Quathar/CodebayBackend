package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * <h1>Read All Models Use Case Implementation</h1>
 *
 * @see ReadAllModelsUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadAllModelsUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private ReadAllModelsUseCase<Object> readAllModelsUseCase;

    // <<-TEST->>
    @Test
    void GivenPageIndexAndPageSize_WhenReadModels_ThenFindAllMethodIsInvoked() {
        // [Given]
        var pageIndex = 0;
        var pageSize  = 100;

        // [When]
        this.readAllModelsUseCase.getAll(pageIndex, pageSize);

        // [Then]
        var wantedNumOfInvocations = 1;
        verify(this.crudRepositoryPort, times(wantedNumOfInvocations)).findAll(pageIndex, pageSize);
    }

}
