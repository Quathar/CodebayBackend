package com.quathar.codebay.infra.security.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.Role;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Role Mapper</h1>
 *
 * @param <R> The request or response to generate the mapper.
 *
 * @see Role
 * @see ModelMapperPort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpRoleMapper<R> extends ModelMapperPort<Role, R> {
}
