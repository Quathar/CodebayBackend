package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.infra.jpa.entity.security.OperationEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Operation Mapper</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OperationMapper extends ModelMapperPort<Operation, OperationEntity> {

    /**
     * Instance of the OperationMapper created by MapStruct.
     */
    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

}
