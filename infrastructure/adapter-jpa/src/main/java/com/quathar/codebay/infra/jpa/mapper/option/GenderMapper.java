package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.valueobject.option.Gender;
import com.quathar.codebay.infra.jpa.entity.option.GenderEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Gender Mapper</h1>
 *
 * @see BaseOptionMapper
 * @see Gender
 * @see GenderEntity
 * @since 2023-05-18
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface GenderMapper extends BaseOptionMapper<Gender, GenderEntity>{
}
