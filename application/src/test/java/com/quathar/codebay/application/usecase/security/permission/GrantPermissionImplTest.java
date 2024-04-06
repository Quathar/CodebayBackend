package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.OperationRepositoryPort;
import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;
import com.quathar.codebay.application.outputport.security.RoleRepositoryPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * <h1>Grant Permission Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class GrantPermissionImplTest {

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @Mock
    private RoleRepositoryPort roleRepositoryPort;
    @Mock
    private OperationRepositoryPort operationRepositoryPort;
    @InjectMocks
    private GrantPermissionImpl grantPermissionImpl;

    // <<-TEST->>
    @Test
    void GivenRoleNameAndOperationName_whenGrantPermission_thenPermissionIsGrantedCorrectly() {
        // [Given]
        var roleName      = "ROLE_EXAMPLE";
        var operationName = "PASS_THIS_TEST";

        when( this.roleRepositoryPort.findByName(roleName) )
                .thenReturn(Optional.of(
                        Role.builder()
                                .id( UUID.randomUUID() )
                                .name( roleName )
                                .description( "randomDescription" )
                                .build()
                ));
        when( this.operationRepositoryPort.findByName(operationName) )
                .thenReturn(Optional.of(
                        Operation.builder()
                                .id( UUID.randomUUID() )
                                .name( operationName )
                                .build()
                ));
        when( this.permissionRepositoryPort.save( any(GrantedPermission.class) ) )
                .thenAnswer(invocation -> {
                    var retrievedPermission = invocation.getArgument(0, GrantedPermission.class);
                    retrievedPermission.setId( java.util.UUID.randomUUID() );
                    return retrievedPermission;
                });

        // [When]
        var permissionToGrant = GrantedPermission.builder()
                .role( Role.builder().name(roleName).build() )
                .operation( Operation.builder().name(operationName).build() )
                .build();
        GrantedPermission grantedPermission = this.grantPermissionImpl.grant(permissionToGrant);

        // [Then]
        assertThat( grantedPermission.getId()                    ).isNotNull();
        assertThat( grantedPermission.getRole().getId()          ).isNotNull();
        assertThat( grantedPermission.getRole().getName()        ).isEqualTo( roleName );
        assertThat( grantedPermission.getRole().getDescription() ).isNotNull();
        assertThat( grantedPermission.getOperation().getId()     ).isNotNull();
        assertThat( grantedPermission.getOperation().getName()   ).isEqualTo( operationName );
    }

}
