package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.Operation;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Operation Mapper</h1>
 *
 * @param <R> The request or response to generate the mapper.
 *
 * @see Operation
 * @see ModelMapperPort
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpOperationMapper<R> extends ModelMapperPort<Operation, R> {
}
