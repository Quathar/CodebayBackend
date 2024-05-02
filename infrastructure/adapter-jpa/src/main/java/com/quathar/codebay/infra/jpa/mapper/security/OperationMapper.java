package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.entity.security.OperationEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Operation Mapper</h1>
 *
 * @see MapperServicePort
 * @see Operation
 * @see OperationEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface OperationMapper extends MapperServicePort<Operation, OperationEntity> {
}
