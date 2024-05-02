package com.quathar.codebay.app.rest.common.model.mapper;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;

/**
 * <h1>HTTP (HyperText Transfer Protocol) Administrator Response Mapper</h1>
 *
 * @param <R> The response to generate the mapper.
 *
 * @see MapFromModel
 * @see Administrator
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public interface HttpAdminResponseMapper<R> extends MapFromModel<Administrator, R> {
}
