package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

/**
 * <h1>Delete Model Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class DeleteModelImplTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<?, UUID> crudRepositoryPort;
    @InjectMocks
    private DeleteModelImpl<UUID> createModelImpl;

    // <<-TEST->>
    @Test
    void GivenAnID_WhenDeleteModel_ThenDeleteByIdMethodIsInvoked() {
        // [Given]
        var id = UUID.randomUUID();

        // [When]
        this.createModelImpl.deleteById(id);

        // [Then]
        Mockito.verify( this.crudRepositoryPort, Mockito.times(1) )
                .deleteById(id);
    }

}
