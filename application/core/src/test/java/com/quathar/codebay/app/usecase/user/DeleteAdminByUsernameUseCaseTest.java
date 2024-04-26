package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * <h1>Delete Administrator by Username Use Case Implementation Test</h1>
 *
 * @see DeleteAdminByUsernameUseCase
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class DeleteAdminByUsernameUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private AdministratorRepositoryPort adminRepositoryPort;
    @InjectMocks
    private DeleteAdminByUsernameUseCase deleteAdminByUsernameUseCase;

    // <<-TEST->>
    @Test
    void GivenValidUsername_WhenDeleteAdminByUsername_ThenFindByUsernameAndSaveInvokedOnce() {
        // [Given]
        var username = "username";
        var mockedAdmin = Administrator.builder()
                        .username(username)
                        .build();

        when( this.adminRepositoryPort.findByUsername(username) )
                .thenAnswer(invocation -> of(mockedAdmin));

        // [When]
        this.deleteAdminByUsernameUseCase.deleteByUsername(username);

        // [Then]
        verify(this.adminRepositoryPort, times(1)).findByUsername(username);
        verify(this.adminRepositoryPort, times(1)).save(mockedAdmin);
        verifyNoMoreInteractions(this.adminRepositoryPort);
    }

}
