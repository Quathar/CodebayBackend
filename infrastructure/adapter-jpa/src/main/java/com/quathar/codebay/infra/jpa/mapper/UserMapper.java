package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.embeddable.mapper.AuditMapper;
import com.quathar.codebay.infra.jpa.entity.UserEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>User Mapper</h1>
 *
 * @see MapperServicePort
 * @see User
 * @see UserEntity
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, uses = {
        RoleMapper.class,
        AuditMapper.class
}, unmappedTargetPolicy = IGNORE)
public interface UserMapper extends MapperServicePort<User, UserEntity> {
}
