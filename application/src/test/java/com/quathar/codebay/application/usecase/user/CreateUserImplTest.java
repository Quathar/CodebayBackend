package com.quathar.codebay.application.usecase.user;

import com.quathar.codebay.application.inputport.security.PasswordEncoderPort;
import com.quathar.codebay.application.outputport.UserRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.Role;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * <h1>Create User Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class CreateUserImplTest {

    // <<-FIELDS->>
    @Mock
    private UserRepositoryPort userRepositoryPort;
    @Mock
    private RoleRepositoryPort roleRepositoryPort;
    @Mock
    private PasswordEncoderPort passwordEncoderPort;
    @InjectMocks
    private CreateUserImpl createUserImpl;

    // <<-TESTS->>
    @Test
    void GivenValidUserData_WhenCreatingUser_ThenUserIsCreatedSuccessfullyWithDefaultRoleAndEncodedPassword() {
        // [Given]
        var username = "jdoe";
        var password = "safePasswordÑ";
        var nickname = "John Doe";
        var email = "jdoe@email.com";

        var user = User.builder()
                .username( username )
                .password( password )
                .nickname( nickname )
                .email( email )
                .build();

        var userRole = "USER";
        var role = Role.builder()
                .id( UUID.randomUUID() )
                .name( userRole )
                .build();
        when( this.userRepositoryPort.save( any(User.class) ) )
                .thenAnswer(invocation -> {
                    var retrievedUser = invocation.getArgument(0, User.class);
                    retrievedUser.setId( UUID.randomUUID() );
                    return retrievedUser;
                });
        when( this.roleRepositoryPort.findByName(userRole) ).thenReturn( Optional.of(role) );
        when( this.passwordEncoderPort.encode(password) ).thenReturn( "encodedPassword" );

        // [When]
        User userToTest = this.createUserImpl.create(user);

        // [Then]
        assertThat( userToTest.getId()                     ).isNotNull();
        assertThat( userToTest.getUsername()               ).isEqualTo( username );
        // Since the password MUST BE encoded
        assertThat( userToTest.getPassword()               ).isNotEqualTo( password );
        assertThat( userToTest.getNickname()               ).isEqualTo( nickname );
        assertThat( userToTest.getEmail()                  ).isEqualTo( email );
        assertThat( userToTest.getStatus()                 ).isNotNull();
        assertThat( userToTest.getRole()                   ).isNotNull();
        assertThat( userToTest.getSuccessfulAuth()         ).isEqualTo( 0 );
        assertThat( userToTest.getFailedAuth()             ).isEqualTo( 0 );
        assertThat( userToTest.getCreationDate()           ).isNotNull();
        assertThat( userToTest.getPasswordExpirationDate() ).isNotNull();
        assertThat( userToTest.getLastConnection()         ).isNotNull();
    }

}
