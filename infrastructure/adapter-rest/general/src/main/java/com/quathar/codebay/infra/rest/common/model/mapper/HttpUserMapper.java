package com.quathar.codebay.infra.rest.common.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.User;

/**
 * <h1>HTTP (HyperText Transfer Protocol) User Mapper</h1>
 *
 * @param <R> The request or response to generate the mapper.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpUserMapper<R> extends ModelMapperPort<User, R> {
}
