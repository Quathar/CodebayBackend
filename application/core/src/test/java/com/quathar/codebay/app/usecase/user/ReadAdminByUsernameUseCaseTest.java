package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static java.util.UUID.randomUUID;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <h1>Read Administrator by Username Use Case Implementation Test</h1>
 *
 * @see ReadAdminByUsernameUseCase
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadAdminByUsernameUseCaseTest {

    // <<-FIELD->>
    @Mock
    private AdministratorRepositoryPort adminRepositoryPort;
    @InjectMocks
    private ReadAdminByUsernameUseCase readByUsernameUseCase;

    @Test
    void GivenUsername_WhenFindingAdmin_ThenFindByUsernameMethodIsInvokedOnce() {
        // [Given]
        var username = "username";
        var mockedAdmin = Administrator.builder()
                .id( randomUUID() )
                .build();

        when(this.adminRepositoryPort.findByUsername(username))
                .thenAnswer(invocation -> of(mockedAdmin));

        // [When]
        this.readByUsernameUseCase.getByUsername(username);

        // [Then]
        verify(this.adminRepositoryPort, only()).findByUsername(username);
    }

}
