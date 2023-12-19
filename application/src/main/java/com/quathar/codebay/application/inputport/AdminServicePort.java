package com.quathar.codebay.application.inputport;

import com.quathar.codebay.domain.model.Administrator;

import java.util.UUID;

/**
 * <h1>Admin Service Port</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
public interface AdminServicePort extends CrudServicePort<Administrator, UUID> {
}
