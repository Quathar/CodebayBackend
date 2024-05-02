package com.quathar.codebay.app.usecase.security.authorization;

import com.quathar.codebay.domain.port.out.security.PermissionRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * <h1>Revoke Permission Use Case Implementation Test</h1>
 *
 * @see RevokePermissionUseCase
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class RevokePermissionUseCaseTest {

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @InjectMocks
    private RevokePermissionUseCase revokePermissionUseCase;

    // <<-TEST->>
    @Test
    void GivenPermissionId_WhenRevokePermission_thenDeleteByIdIsInvokedOnce() {
        // [Given]
        var id = java.util.UUID.randomUUID();

        // [When]
        this.revokePermissionUseCase.revoke(id);

        // [Then]
        verify(this.permissionRepositoryPort, only()).deleteById(id);
    }

}
