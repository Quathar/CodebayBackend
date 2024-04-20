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
 * <h1>Update Model Use Case Implementation Test</h1>
 *
 * @see UpdateModelUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class UpdateModelUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private UpdateModelUseCase<Object> updateModelUseCase;

    // <<-TEST->>
    @Test
    void GivenAModel_WhenUpdateModel_ThenUpdateMethodIsInvoked() {
        // [Given]
        var model = new Object();

        // [When]
        this.updateModelUseCase.update(model);

        // [Then]
        var wantedNumOfInvocations = 1;
        verify(this.crudRepositoryPort, times(wantedNumOfInvocations)).update(model);
    }

}
