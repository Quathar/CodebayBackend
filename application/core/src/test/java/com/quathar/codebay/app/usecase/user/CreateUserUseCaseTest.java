package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.domain.port.out.user.UserRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.time.LocalDateTime.now;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <h1>Create User Use Case Implementation Test</h1>
 *
 * @see CreateUserUseCase
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    // <<-CONSTANTS->>
    private static final int ZERO = 0;
    private static final String USER_ROLE = "USER";

    // <<-FIELDS->>
    @Mock
    private UserRepositoryPort userRepositoryPort;
    @Mock
    private RoleRepositoryPort roleRepositoryPort;
    @Mock
    private PasswordServicePort passwordServicePort;
    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    // <<-TEST->>
    @Test
    void GivenUserDetails_WhenUserIsCreated_ThenUserIsInitializedWithDefaultValues() {
        // [Given]
        var username = "username";
        var password = "password";
        var email    = "email";
        var nickname = "nickname";
        
        var userToRegister = User.builder()
                .username( username )
                .password( password )
                .email   ( email    )
                .nickname( nickname )
                .build();

        when(this.userRepositoryPort.save(any(User.class)))
                .thenAnswer(invocation -> {
                    User userInArguments = invocation.getArgument(0);
                    // Theoretically we would have to create a new object
                    // for the user we are going to return,
                    // but this is a test and I don't care
                    userInArguments.setId( randomUUID() );
                    return userInArguments;
                });
        when(this.roleRepositoryPort.findByName(USER_ROLE))
                .thenAnswer(invocation -> {
                    String roleName = invocation.getArgument(0);
                    var mockedRole = Role.builder()
                            .id( randomUUID() )
                            .name( roleName )
                            .build();
                    return of(mockedRole);
                });
        when(this.passwordServicePort.encode(password))
                .thenAnswer(invocation -> invocation.getArgument(0) + "Encoded");

        // [When]
        User retrievedUser = this.createUserUseCase.create(userToRegister);

        // [Then]
        verify(this.userRepositoryPort,  only()).save(any(User.class));
        verify(this.roleRepositoryPort,  only()).findByName(USER_ROLE);
        verify(this.passwordServicePort, only()).encode(password);

        assertThat( retrievedUser.getId()       ).isNotNull   ();
        assertThat( retrievedUser.getUsername() ).isEqualTo   ( username );
        assertThat( retrievedUser.getPassword() ).isNotEqualTo( password );
        assertThat( retrievedUser.getEmail()    ).isEqualTo   ( email );
        assertThat( retrievedUser.getNickname() ).isEqualTo   ( nickname );
        assertThat( retrievedUser.getStatus()   ).isEqualTo   ( "ENABLED" );

        assertThat( retrievedUser.getSuccessfulAuth() ).isEqualTo( ZERO );
        assertThat( retrievedUser.getFailedAuth()     ).isEqualTo( ZERO );

        assertThat( retrievedUser.getRole()                    ).isNotNull();
        assertThat( retrievedUser.getLastConnection()          ).isBefore ( now() );
        assertThat( retrievedUser.getPasswordExpirationDate()  ).isAfter  ( now() );
        assertThat( retrievedUser.getAudit()                   ).isNotNull();
        assertThat( retrievedUser.getAudit().getCreationDate() ).isBefore ( now() );
    }

}
