package com.quathar.codebay.app.rest.management.model.user.mapper.request;

import com.quathar.codebay.app.rest.common.model.mapper.HttpAdminRequestMapper;
import com.quathar.codebay.app.rest.management.model.user.request.UpdateAdminRequest;
import com.quathar.codebay.domain.model.Administrator;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Update Administrator Request Mapper</h1>
 *
 * @see HttpAdminRequestMapper
 * @see UpdateAdminRequest
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = IGNORE)
public interface UpdateAdminRequestMapper extends HttpAdminRequestMapper<UpdateAdminRequest> {

    @Override
    @Mapping(source = "name", target = "personalInfo.name")
    @Mapping(source = "surnames", target = "personalInfo.surnames")
    @Mapping(source = "gender", target = "personalInfo.gender")
    @Mapping(source = "birthdate", target = "personalInfo.birthdate")
    @Mapping(source = "documentType", target = "personalInfo.document.type")
    @Mapping(source = "document", target = "personalInfo.document.content")
    @Mapping(source = "countryCode", target = "personalInfo.phone.countryCode")
    @Mapping(source = "number", target = "personalInfo.phone.number")
    Administrator toModel(UpdateAdminRequest other);

}
