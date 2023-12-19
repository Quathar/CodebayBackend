package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ModelMapper;
import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Admin Mapper</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper extends ModelMapper<Administrator, AdministratorEntity> {

    /**
     * Instance of the AdminMapper created by MapStruct.
     */
    static AdminMapper getInstance() {
        return Mappers.getMapper(AdminMapper.class);
    }

}
