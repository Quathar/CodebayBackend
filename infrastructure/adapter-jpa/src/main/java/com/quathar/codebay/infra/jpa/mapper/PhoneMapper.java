package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ValueObjectMapperPort;
import com.quathar.codebay.domain.model.valueobject.Phone;
import com.quathar.codebay.infra.jpa.entity.embeddable.PhoneEmbeddable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Phone Mapper</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhoneMapper extends ValueObjectMapperPort<Phone, PhoneEmbeddable> {

    /**
     * Instance of the PhoneMapper created by MapStruct.
     */
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

}
