package com.quathar.codebay.infra.jpa.mapper.user;

import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.infra.jpa.embeddable.mapper.AuditMapper;
import com.quathar.codebay.infra.jpa.embeddable.mapper.PersonalInfoMapper;
import com.quathar.codebay.infra.jpa.entity.CustomerEntity;
import com.quathar.codebay.infra.jpa.mapper.security.RoleMapper;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Customer Mapper</h1>
 *
 * @see MapperServicePort
 * @see Customer
 * @see CustomerEntity
 * @since 2024-05-07
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, uses = {
        RoleMapper.class,
        AuditMapper.class,
        PersonalInfoMapper.class
})
public interface CustomerMapper extends MapperServicePort<Customer, CustomerEntity> {
}
