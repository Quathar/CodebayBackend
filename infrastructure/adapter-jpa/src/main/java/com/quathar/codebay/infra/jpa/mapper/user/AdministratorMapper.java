package com.quathar.codebay.infra.jpa.mapper.user;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.embeddable.mapper.AuditMapper;
import com.quathar.codebay.infra.jpa.embeddable.mapper.PersonalInfoMapper;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Administrator Mapper</h1>
 *
 * @see MapperServicePort
 * @see Administrator
 * @see AdministratorEntity
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING,
        uses = {
    RoleMapper.class,
    AuditMapper.class,
    PersonalInfoMapper.class
}, unmappedTargetPolicy = IGNORE)
public interface AdministratorMapper extends MapperServicePort<Administrator, AdministratorEntity> {
}
