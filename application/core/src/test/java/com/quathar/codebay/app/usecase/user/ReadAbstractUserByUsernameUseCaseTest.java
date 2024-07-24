package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

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
 * <h1>Read abstract user by username Use Case Implementation Test</h1>
 *
 * @see ReadAbstractUserByUsernameUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
public class ReadAbstractUserByUsernameUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private UserRepositoryPort userRepositoryPort;
    @InjectMocks
    private ReadAbstractUserByUsernameUseCase<User> readByUsernameUseCase;

    // <<-TEST->>
    @Test
    void GivenUsername_WhenFindingUser_ThenFindByUsernameMethodIsInvokedOnce() {
        // [Given]
        var username = "username";
        var mockedUser = User.builder()
                .id( randomUUID() )
                .build();

        when(this.userRepositoryPort.findByUsername(username))
                .thenAnswer(invocation -> of(mockedUser));

        // [When]
        this.readByUsernameUseCase.getByUsername(username);

        // [Then]
        verify(this.userRepositoryPort, only()).findByUsername(username);
    }

}
