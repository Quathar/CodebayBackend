package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

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
 * <h1>Delete User by Username Use Case Test</h1>
 *
 * @see DeleteUserByUsernameUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class DeleteUserByUsernameUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private UserRepositoryPort userRepositoryPort;
    @InjectMocks
    private DeleteUserByUsernameUseCase deleteUserByUsernameUseCase;

    // <<-TEST->>
    @Test
    void GivenValidUsername_WhenDeleteUserByUsername_ThenFindByUsernameAndSaveInvokedOnce() {
        // [Given]
        var username = "username";
        var mockedUser = User.builder()
                .username(username)
                .build();

        when( this.userRepositoryPort.findByUsername(username) )
                .thenAnswer(invocation -> of(mockedUser));

        // [When]
        this.deleteUserByUsernameUseCase.deleteByUsername(username);

        // [Then]
        verify(this.userRepositoryPort, times(1)).findByUsername(username);
        verify(this.userRepositoryPort, times(1)).save(mockedUser);
        verifyNoMoreInteractions(this.userRepositoryPort);
    }

}
