package com.quathar.codebay.infra.security.model.mapper;

import com.quathar.codebay.infra.security.model.SecurityUser;
import com.quathar.codebay.infra.rest.common.model.mapper.UserHttpMapper;

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
public interface UserDetailsMapper extends UserHttpMapper<SecurityUser> {
}
