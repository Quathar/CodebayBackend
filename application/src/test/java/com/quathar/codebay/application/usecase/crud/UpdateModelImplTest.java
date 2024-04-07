package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <h1>Update Model Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class UpdateModelImplTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private UpdateModelImpl<Object> createModelImpl;

    // <<-TEST->>
    @Test
    void GivenAModel_WhenUpdateModel_ThenUpdateMethodIsInvoked() {
        // [Given]
        var model = new Object();

        // [When]
        this.createModelImpl.update(model);

        // [Then]
        Mockito.verify( this.crudRepositoryPort, Mockito.times(1) )
                .update(model);
    }

}
