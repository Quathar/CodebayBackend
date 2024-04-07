package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <h1>Create Model Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class CreateModelImplTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private CreateModelImpl<Object> createModelImpl;

    // <<-TEST->>
    @Test
    void GivenAModel_WhenCreateModel_ThenSaveMethodIsInvoked() {
        // [Given]
        var model = new Object();

        // [When]
        this.createModelImpl.create(model);

        // [Then]
        Mockito.verify( this.crudRepositoryPort, Mockito.times(1) )
                .save(model);
    }

}
