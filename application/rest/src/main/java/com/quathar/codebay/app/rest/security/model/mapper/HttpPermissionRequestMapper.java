package com.quathar.codebay.app.rest.security.model.mapper;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Permission Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see GrantedPermission
 * @see MapToModel
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpPermissionRequestMapper<R> extends MapToModel<R, GrantedPermission> {
}
