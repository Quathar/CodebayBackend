package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Role Mapper</h1>
 *
 * @see MapperServicePort
 * @see Role
 * @see RoleEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, uses = PermissionMapper.class, unmappedTargetPolicy = IGNORE)
public interface RoleMapper extends MapperServicePort<Role, RoleEntity> {
}
