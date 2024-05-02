package com.quathar.codebay.infra.jpa.embeddable.mapper;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.PersonalInfo;
import com.quathar.codebay.infra.jpa.embeddable.PersonalInfoEmbeddable;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Personal Info Mapper</h1>
 *
 * @see MapperServicePort
 * @see PersonalInfo
 * @see PersonalInfoEmbeddable
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, uses = {DocumentMapper.class, PhoneMapper.class}, unmappedTargetPolicy = IGNORE)
public interface PersonalInfoMapper extends MapperServicePort<PersonalInfo, PersonalInfoEmbeddable> {
}
