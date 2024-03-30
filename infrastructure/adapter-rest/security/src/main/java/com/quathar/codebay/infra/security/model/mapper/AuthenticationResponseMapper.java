package com.quathar.codebay.infra.security.model.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.TokenPair;
import com.quathar.codebay.infra.security.model.response.AuthenticationResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>Authentication Response Mapper</h1>
 *
 * @see AuthenticationResponse
 * @see TokenPair
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthenticationResponseMapper extends ModelMapperPort<TokenPair, AuthenticationResponse> {
}
