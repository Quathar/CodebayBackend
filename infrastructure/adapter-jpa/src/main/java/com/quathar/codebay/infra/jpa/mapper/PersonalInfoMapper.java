package com.quathar.codebay.infra.jpa.mapper;

import com.quathar.codebay.application.commonport.ValueObjectMapperPort;
import com.quathar.codebay.domain.model.valueobject.PersonalInfo;
import com.quathar.codebay.infra.jpa.entity.embeddable.PersonalInfoEmbeddable;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Personal Info Mapper</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Mapper(uses = {
        DocumentMapper.class,
        PhoneMapper.class
}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonalInfoMapper extends ValueObjectMapperPort<PersonalInfo, PersonalInfoEmbeddable> {

    /**
     * Instance of the PersonalInfoMapper created by MapStruct.
     */
    PersonalInfoMapper INSTANCE = Mappers.getMapper(PersonalInfoMapper.class);

}
