package com.quathar.codebay.app.usecase.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.security.PasswordServicePort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;
import com.quathar.codebay.domain.port.out.user.AdministratorRepositoryPort;
import com.quathar.codebay.domain.valueobject.PersonalInfo;

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
 * <h1>Create Administrator Use Case Implementation Test</h1>
 *
 * @see CreateAdminUseCase
 * @since 2024-04-XX
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class CreateAdminUseCaseTest {

    // <<-CONSTANTS->>
    private static final int ZERO = 0;
    private static final String ADMIN_ROLE = "ASSISTANT";

    // <<-FIELDS->>
    @Mock
    private AdministratorRepositoryPort adminRepositoryPort;
    @Mock
    private RoleRepositoryPort roleRepositoryPort;
    @Mock
    private PasswordServicePort passwordServicePort;
    @InjectMocks
    private CreateAdminUseCase createAdminUseCase;

    // <<-TEST->>
    @Test
    void GivenAdminDetails_WhenAdminIsCreated_ThenAdminIsInitializedWithDefaultValues() {
        // [Given]
        var username = "username";
        var password = "password";
        var email    = "email";
        var nickname = "nickname";

        var personalInfo   = PersonalInfo.builder().build();
        var userToRegister = Administrator.builder()
                .username    ( username     )
                .password    ( password     )
                .email       ( email        )
                .nickname    ( nickname     )
                .personalInfo( personalInfo )
                .build();

        when(this.adminRepositoryPort.save(any(Administrator.class)))
                .thenAnswer(invocation -> {
                    Administrator adminInArguments = invocation.getArgument(0);
                    // Theoretically we would have to create a new object
                    // for the user we are going to return,
                    // but this is a test and I don't care
                    adminInArguments.setId( randomUUID() );
                    return adminInArguments;
                });
        when(this.roleRepositoryPort.findByName(ADMIN_ROLE))
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
        Administrator retrievedAdmin = this.createAdminUseCase.create(userToRegister);

        // [Then]
        verify(this.adminRepositoryPort, only()).save(any(Administrator.class));
        verify(this.roleRepositoryPort,  only()).findByName(ADMIN_ROLE);
        verify(this.passwordServicePort, only()).encode(password);

        assertThat( retrievedAdmin.getId()       ).isNotNull   ();
        assertThat( retrievedAdmin.getUsername() ).isEqualTo   ( username );
        assertThat( retrievedAdmin.getPassword() ).isNotEqualTo( password );
        assertThat( retrievedAdmin.getEmail()    ).isEqualTo   ( email );
        assertThat( retrievedAdmin.getNickname() ).isEqualTo   ( nickname );
        assertThat( retrievedAdmin.getStatus()   ).isEqualTo   ( "ENABLED" );

        assertThat( retrievedAdmin.getSuccessfulAuth() ).isEqualTo( ZERO );
        assertThat( retrievedAdmin.getFailedAuth()     ).isEqualTo( ZERO );

        assertThat( retrievedAdmin.getRole()                    ).isNotNull();
        assertThat( retrievedAdmin.getLastConnection()          ).isBefore ( now() );
        assertThat( retrievedAdmin.getPasswordExpirationDate()  ).isAfter  ( now() );
        assertThat( retrievedAdmin.getAudit()                   ).isNotNull();
        assertThat( retrievedAdmin.getAudit().getCreationDate() ).isBefore ( now() );

        assertThat( retrievedAdmin.getPersonalInfo() ).isEqualTo( personalInfo );
    }

}
