package com.quathar.codebay.application.usecase.security.permission;

import com.quathar.codebay.application.outputport.security.PermissionRepositoryPort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * <h1>Revoke Permission Use Case Implementation Test</h1>
 *
 * @author Q
 */
@ExtendWith(MockitoExtension.class)
class RevokePermissionImplTest {

    // <<-FIELDS->>
    @Mock
    private PermissionRepositoryPort permissionRepositoryPort;
    @InjectMocks
    private RevokePermissionImpl revokePermissionImpl;

    // <<-TEST->>
    @Test
    void GivenAnPermissionID_whenRevokePermission_thenPermissionRepositoryPortIsInvokedOnce() {
        // [Given]
        var id = java.util.UUID.randomUUID();

        // [When]
        this.revokePermissionImpl.revoke(id);

        // [Then]
        // Verify that the repository port is invoked only once
        verify(this.permissionRepositoryPort, times(1)).deleteById(id);
    }

}
