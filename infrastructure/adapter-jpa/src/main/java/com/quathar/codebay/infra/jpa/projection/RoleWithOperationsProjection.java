package com.quathar.codebay.infra.jpa.projection;

/**
 * <h1>Role with Operations Projection</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface RoleWithOperationsProjection {

    /**
     * Retrieves the name of the role.
     *
     * @return the name of the role
     */
    String getRoleName();

    /**
     * Retrieves the operations associated with the role in JSON format.
     *
     * @return the operations associated with the role in JSON format
     */
    String getOperationsInJson();

}
