package com.quathar.codebay.app.usecase;

import com.quathar.codebay.domain.port.out.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <h1>Read Model Use Case Implementation Test</h1>
 *
 * @see ReadModelUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadModelUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, UUID> crudRepositoryPort;
    @InjectMocks
    private ReadModelUseCase<Object, UUID> readModelUseCase;

    // <<-TEST->>
    @Test
    void GivenAnID_WhenReadAModel_ThenFindByIdMethodIsInvoked() {
        // [Given]
        var id = UUID.randomUUID();
        var objectToRetrieve = new Object();

        when( this.crudRepositoryPort.findById(id) )
                .thenAnswer(invocation -> java.util.Optional.of(objectToRetrieve));

        // [When]
        this.readModelUseCase.getById(id);

        // [Then]
        var wantedNumOfInvocations = 1;
        verify(this.crudRepositoryPort, times(wantedNumOfInvocations)).findById(id);
    }

}
