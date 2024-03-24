package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Role Mapper</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ModelMapperPort<Role, RoleEntity> {

    /**
     * Instance of the RoleMapper created by MapStruct.
     */
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

}
