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
 * <h1>Create Model Use Case Implementation Test</h1>
 *
 * @see CreateModelUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class CreateModelUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private CreateModelUseCase<Object> createModelUseCase;

    // <<-TEST->>
    @Test
    void GivenAModel_WhenCreateModel_ThenSaveMethodIsInvoked() {
        // [Given]
        var model = new Object();

        // [When]
        this.createModelUseCase.create(model);

        // [Then]
        var wantedNumOfInvocations = 1;
        verify(this.crudRepositoryPort, times(wantedNumOfInvocations)).save(model);
    }

}
