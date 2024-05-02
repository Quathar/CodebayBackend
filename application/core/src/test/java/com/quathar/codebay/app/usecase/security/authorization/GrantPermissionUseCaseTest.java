package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.security.OperationRepositoryPort;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.port.out.security.RoleRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static java.util.UUID.randomUUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <h1>Grant Permission Use Case Implementation Test</h1>
 *
 * @see GrantPermissionUseCase
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class GrantPermissionUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @Mock
    private RoleRepositoryPort roleRepositoryPort;
    @Mock
    private OperationRepositoryPort operationRepositoryPort;
    @InjectMocks
    private GrantPermissionUseCase grantPermissionUseCase;

    // <<-TEST->>
    private Role getMockedRole(String roleName) {
        return Role.builder()
                .id(randomUUID())
                .name(roleName)
                .build();
    }

    private Operation getMockedOperation(String operationName) {
        return Operation.builder()
                .id(randomUUID())
                .name(operationName)
                .build();
    }

    @Test
    void GivenValidRoleAndOperation_WhenGrantPermission_ThenPermissionIsSaved() {
        // [Given]
        var roleName      = "TEST_ROLE";
        var operationName = "READ_TEST";

        when( this.roleRepositoryPort.findByName(roleName) )
                .thenAnswer(invocation -> of( this.getMockedRole(roleName) ));
        when( this.operationRepositoryPort.findByName(operationName) )
                .thenAnswer(invocation -> of( this.getMockedOperation(operationName) ));

        // [When]
        this.grantPermissionUseCase.grant(roleName, operationName);

        // [Then]
        verify(this.roleRepositoryPort,       only()).findByName(roleName);
        verify(this.operationRepositoryPort,  only()).findByName(operationName);
        verify(this.permissionRepositoryPort, only()).save(any(GrantedPermission.class));
    }

}
