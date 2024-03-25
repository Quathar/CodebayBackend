package com.quathar.codebay.infra.security.model.response;

/**
 * <h1>Granted Permission Response</h1>
 *
 * @param id        The ID of the granted permission
 * @param role      The role associated with the permission.
 * @param operation The operation associated with the permission.
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public record GrantedPermissionResponse(
        java.util.UUID   id,
        String           role,
        String           operation
) {}
