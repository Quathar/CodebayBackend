package com.quathar.codebay.app.rest.security.model.mapper;

import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Role Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see Role
 * @see MapToModel
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpRoleRequestMapper<R> extends MapToModel<R, Role> {
}
