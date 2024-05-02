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

/**
 * <h1>Delete Model Use Case Implementation Test</h1>
 *
 * @see DeleteModelUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class DeleteModelUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<?, UUID> crudRepositoryPort;
    @InjectMocks
    private DeleteModelUseCase<UUID> deleteModelUseCase;

    // <<-TEST->>
    @Test
    void GivenAnID_WhenDeleteModel_ThenDeleteByIdMethodIsInvoked() {
        // [Given]
        var id = UUID.randomUUID();

        // [When]
        this.deleteModelUseCase.deleteById(id);

        // [Then]
        var wantedNumOfInvocations = 1;
        verify(this.crudRepositoryPort, times(wantedNumOfInvocations)).deleteById(id);
    }

}
