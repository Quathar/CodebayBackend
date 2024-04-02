package com.quathar.codebay.infra.rest.common.model.mapper;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.usecase.mapper.MapToModelUseCase;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Administrator Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public interface HttpAdminRequestMapper<R> extends MapToModelUseCase<R, Administrator> {
}
