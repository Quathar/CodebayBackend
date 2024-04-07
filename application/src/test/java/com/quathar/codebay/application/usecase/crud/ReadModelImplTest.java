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
 * <h1>Read Model Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadModelImplTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, UUID> crudRepositoryPort;
    @InjectMocks
    private ReadModelImpl<Object, UUID> readModelImpl;

    // <<-TEST->>
    @Test
    void GivenAnID_WhenReadAModel_ThenFindByIdMethodIsInvoked() {
        // [Given]
        var id = UUID.randomUUID();

        Mockito.when( this.crudRepositoryPort.findById(id) )
                .thenAnswer( invocation -> java.util.Optional.of(new Object()) );

        // [When]
        this.readModelImpl.getById(id);

        // [Then]
        Mockito.verify( this.crudRepositoryPort, Mockito.times(1) )
                .findById(id);
    }

}
