package com.quathar.codebay.application.usecase.crud;

import com.quathar.codebay.application.outputport.CrudRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <h1>Read All Models Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadAllModelsImplTest {

    // <<-FIELDS->>
    @Mock
    private CrudRepositoryPort<Object, ?> crudRepositoryPort;
    @InjectMocks
    private ReadAllModelsImpl<Object> createModelImpl;

    // <<-TEST->>
    @Test
    void GivenPageIndexAndPageSize_WhenReadModels_ThenFindAllMethodIsInvoked() {
        // [Given]
        var pageIndex = 0;
        var pageSize  = 100;

        // [When]
        this.createModelImpl.getAll(pageIndex, pageSize);

        // [Then]
        Mockito.verify( this.crudRepositoryPort, Mockito.times(1) )
                .findAll(pageIndex, pageSize);
    }

}
