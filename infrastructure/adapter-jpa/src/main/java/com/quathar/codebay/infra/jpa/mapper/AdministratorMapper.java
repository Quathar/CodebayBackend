package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Administrator Mapper</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Mapper(uses = {RoleMapper.class, PersonalInfoMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdministratorMapper extends ModelMapperPort<Administrator, AdministratorEntity> {

    /**
     * Instance of the AdministratorMapper created by MapStruct.
     */
    AdministratorMapper INSTANCE = Mappers.getMapper(AdministratorMapper.class);

}
