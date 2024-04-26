package com.quathar.codebay.app.rest.common.model.mapper;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) User Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see MapToModel
 * @see User
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpUserRequestMapper<R> extends MapToModel<R, User> {
}
