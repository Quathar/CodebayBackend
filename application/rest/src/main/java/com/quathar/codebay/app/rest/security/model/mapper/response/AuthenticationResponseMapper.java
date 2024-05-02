package com.quathar.codebay.app.rest.security.model.mapper.response;

import com.quathar.codebay.app.rest.security.model.response.AuthenticationResponse;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;
import com.quathar.codebay.domain.valueobject.security.TokenPair;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Authentication Response Mapper</h1>
 *
 * @see AuthenticationResponse
 * @see TokenPair
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface AuthenticationResponseMapper extends MapFromModel<TokenPair, AuthenticationResponse> {
}
