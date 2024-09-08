package com.quathar.codebay.infra.jpa.mapper.option;

import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.option.BaseOption;
import com.quathar.codebay.infra.jpa.entity.option.BaseOptionEntity;

/**
 * <h1>Base Option Mapper</h1>
 *
 * @see MapperServicePort
 * @see BaseOption
 * @see BaseOptionEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
public interface BaseOptionMapper<M extends BaseOption, T extends BaseOptionEntity>
       extends   MapperServicePort<M, T> {
}
