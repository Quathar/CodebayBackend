package com.quathar.codebay.infra.rest.security.model.mapper;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.usecase.mapper.MapFromModelUseCase;
import com.quathar.codebay.infra.rest.security.model.SecurityUser;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * <h1>User Details Mapper</h1>
 *
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDetailsMapper extends MapFromModelUseCase<User, SecurityUser> {
}
