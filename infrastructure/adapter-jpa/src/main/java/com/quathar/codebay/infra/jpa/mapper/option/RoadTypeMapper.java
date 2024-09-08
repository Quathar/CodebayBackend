package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.valueobject.option.RoadType;
import com.quathar.codebay.infra.jpa.entity.option.RoadTypeEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Road Type Mapper</h1>
 *
 * @see BaseOptionMapper
 * @see RoadType
 * @see RoadTypeEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface RoadTypeMapper extends BaseOptionMapper<RoadType, RoadTypeEntity> {
}
