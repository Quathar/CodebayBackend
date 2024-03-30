package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Permission Mapper</h1>
 *
 * @param <R> The request or response to generate the mapper.
 *
 * @see GrantedPermission
 * @see ModelMapperPort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpPermissionMapper<R> extends ModelMapperPort<GrantedPermission, R> {
}
