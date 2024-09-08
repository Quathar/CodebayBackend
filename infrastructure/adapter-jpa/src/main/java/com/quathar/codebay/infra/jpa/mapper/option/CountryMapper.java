package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.valueobject.option.Country;
import com.quathar.codebay.infra.jpa.entity.option.CountryEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Country Mapper</h1>
 *
 * @see BaseOptionMapper
 * @see Country
 * @see CountryEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface CountryMapper extends BaseOptionMapper<Country, CountryEntity> {
}
