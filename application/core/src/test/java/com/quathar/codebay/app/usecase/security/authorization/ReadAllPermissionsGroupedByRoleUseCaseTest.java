package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * <h1>Read All Grouped by Role Use Case Implementation Test</h1>
 *
 * @see ReadAllPermissionsGroupedByRoleUseCase
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class ReadAllPermissionsGroupedByRoleUseCaseTest {

    // <<-CONSTANTS->>
    private static final List<String> ROLE_NAMES = Arrays.asList("R_0", "R_1", "R_2", "R_3", "R_4");
    private static final List<String> OPERATION_NAMES = Arrays.asList("OP_0", "OP_1", "OP_2", "OP_3", "OP_4");

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @InjectMocks
    private ReadAllPermissionsGroupedByRoleUseCase readAllPermissionsGroupedByRoleUseCase;

    // <<-TEST->>
    @Test
    void GivenNoParameters_WhenGetAllGroupedByRole_ThenFindAllGroupedByRoleIsInvokedOnce() {
        // [Given]

        // [When]
        this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole();

        // [Then]
        verify(this.permissionRepositoryPort, only()).findAllGroupedByRole();
    }

    private Role getMockedRole(int index) {
        return Role.builder()
                .name( ROLE_NAMES.get(index % ROLE_NAMES.size()) )
                .build();
    }

    private Operation getMockedOperation(int index) {
        return Operation.builder()
                .name( OPERATION_NAMES.get(index % OPERATION_NAMES.size()) )
                .build();
    }

    private Stream<GrantedPermission> grantedPermissionStream() {
        var randomNumber = new java.util.Random().nextInt(10, ROLE_NAMES.size() * OPERATION_NAMES.size());
        return Stream.iterate(0, i -> i + 1)
                .map(i -> GrantedPermission.builder()
                        .id( UUID.randomUUID() )
                        .role( this.getMockedRole(i) )
                        .operation( this.getMockedOperation(i) )
                        .build()
                )
                .limit(randomNumber);
    }

    @Test
    void G2ivenPageIndexAndPageSize_WhenGetAllGroupedByRole_ThenFindAllWithPageIndexAndPageSizeIsInvokedOnce() {
        // [Given]
        var pageIndex = 0;
        var pageSize  = 100;

        when( this.permissionRepositoryPort.findAll(pageIndex, pageSize) )
                .thenAnswer(invocation -> this.grantedPermissionStream());

        // [When]
        Stream<RoleOperations> roleOperationsStream = this.readAllPermissionsGroupedByRoleUseCase.getAllGroupedByRole(pageIndex, pageSize);

        // [Then]
        verify(this.permissionRepositoryPort, only()).findAll(pageIndex, pageSize);
        assertThat(roleOperationsStream).isNotNull();
        roleOperationsStream.forEach(entry -> {
            assertThat( entry.getRole() ).isIn(ROLE_NAMES);
            entry.getOperations()
                    .forEach(operation -> assertThat(operation).isIn(OPERATION_NAMES));
        });
    }

}
