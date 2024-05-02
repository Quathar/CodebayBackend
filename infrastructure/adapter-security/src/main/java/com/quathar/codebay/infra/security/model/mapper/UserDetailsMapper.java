package com.quathar.codebay.infra.security.model.mapper;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.mapper.MapFromModel;
import com.quathar.codebay.infra.security.model.SecurityUser;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>User Details Mapper</h1>
 *
 * @see MapFromModel
 * @see User
 * @see SecurityUser
 * @since 2024-03-12
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE) // Maybe componentModel isn't necessary
public interface UserDetailsMapper extends MapFromModel<User, SecurityUser> {

    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

}
