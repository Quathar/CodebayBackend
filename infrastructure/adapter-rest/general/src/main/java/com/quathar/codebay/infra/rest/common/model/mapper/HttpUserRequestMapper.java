package com.quathar.codebay.infra.rest.common.model.mapper;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.usecase.mapper.MapToModelUseCase;

/**
 * <h1>HTTP (HyperText Transfer Protocol) User Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface HttpUserRequestMapper<R> extends MapToModelUseCase<R, User> {
}
