package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.valueobject.option.UserStatus;
import com.quathar.codebay.infra.jpa.entity.option.UserStatusEntity;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>User Status Mapper</h1>
 *
 * @see BaseOptionMapper
 * @see UserStatus
 * @see UserStatusEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface UserStatusMapper extends BaseOptionMapper<UserStatus, UserStatusEntity>{
}
