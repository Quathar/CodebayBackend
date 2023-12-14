package com.quathar.codebay.infra.inputadapter.http.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapper;
import com.quathar.codebay.domain.model.User;

/**
 * <h1>User Http Mapper</h1>
 *
 * @param <R> The request or response to generate the mapper.
 *
 * @since 2023-12-14
 * @version 1.0
 * @author Q
 */
public interface UserHttpMapper<R> extends ModelMapper<User, R> {
}