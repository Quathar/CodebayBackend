package com.quathar.codebay.app.rest.security.model.mapper;

import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.port.out.mapper.MapToModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Operation Request Mapper</h1>
 *
 * @param <R> The request to generate the mapper.
 *
 * @see Operation
 * @see MapToModel
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
public interface HttpOperationRequestMapper<R> extends MapToModel<R, Operation> {
}
