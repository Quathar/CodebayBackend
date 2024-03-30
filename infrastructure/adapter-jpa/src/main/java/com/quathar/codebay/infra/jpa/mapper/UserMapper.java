package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.jpa.entity.UserEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>User Mapper</h1>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Mapper(uses = RoleMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ModelMapperPort<User, UserEntity> {

    /**
     * Instance of the UserMapper created by MapStruct.
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
