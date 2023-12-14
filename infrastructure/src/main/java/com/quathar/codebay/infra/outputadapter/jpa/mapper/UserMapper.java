package com.quathar.codebay.infra.outputadapter.jpa.mapper;

import com.quathar.codebay.application.commonport.ModelMapper;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.infra.outputadapter.jpa.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>User Mapper</h1>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ModelMapper<User, UserEntity> {

    /**
     * Instance of the UserMapper created by MapStruct.
     */
    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }

}
