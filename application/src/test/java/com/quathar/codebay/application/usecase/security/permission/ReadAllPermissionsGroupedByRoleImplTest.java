package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.model.security.RoleOperations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * <h1>Read All Permissions Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadAllPermissionsGroupedByRoleImplTest {

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @InjectMocks
    private ReadAllGroupedByRoleImpl readAllGroupedByRoleImpl;

    // <<-TESTS->>
    // TODO: Finish the tests
    @Test
    void ss() {
        var e1 = RoleOperations.builder()
                .role( null )
                .operations( null )
                .build();
        var e2 = RoleOperations.builder()
                .role( null )
                .operations( null )
                .build();
        // [Given]
        when( this.permissionRepositoryPort.findAllGroupedByRole() )
                .thenReturn( List.of(e1, e2) );

        // [When]
        List<RoleOperations> permissionsGroupedByRole = this.readAllGroupedByRoleImpl.getAllGroupedByRole();

        // [Then]
        permissionsGroupedByRole.forEach(role -> assertThat( role.getRole() ).isNotNull() );
    }

    @Test
    void sss() {
        // [Given]
        when( this.permissionRepositoryPort.findAll( 0, 2) )
                .thenReturn( null );

        // [When]
        List<RoleOperations> permissionsGroupedByRole = this.readAllGroupedByRoleImpl.getAllGroupedByRole(0, 100);

        // [Then]
        permissionsGroupedByRole.forEach(role -> assertThat( role.getRole() ).isNotNull() );
    }

}
