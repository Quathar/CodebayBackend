package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.application.commonport.ModelMapperPort;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.RoleOperations;
import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.projection.RoleWithOperationsProjection;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * <h1>Granted Permission Mapper</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GrantedPermissionMapper extends ModelMapperPort<GrantedPermission, GrantedPermissionEntity> {

    // <<-CONSTANT->>
    /**
     * Instance of the GrantedPermissionMapper created by MapStruct.
     */
    GrantedPermissionMapper INSTANCE = Mappers.getMapper(GrantedPermissionMapper.class);

    // <<-METHODS->>
    /**
     * Extracts operation names from a JSON string.
     *
     * @param operationsInJson The JSON string containing operation names.
     * @return                 An array of operation names.
     */
    private String[] extractOperationNames(String operationsInJson) {
        var beginIndex = 1;
        var endIndex   = operationsInJson.length() - 1;
        var regex      = ",";
        return operationsInJson.substring(beginIndex, endIndex).split(regex);
    }

    /**
     * Converts an array of operation names to a set.
     *
     * @param operationsNames The array of operation names.
     * @return A set of operation names.
     */
    private java.util.Set<String> toSet(String[] operationsNames) {
        return java.util.Arrays.stream(operationsNames)
                .map(String::trim)
                .map(part -> part.replace("\"", ""))
                .collect(java.util.stream.Collectors.toSet());
    }

    /**
     * Maps a projection of RoleWithOperationsProjection to a RoleOperations domain model.
     *
     * @param projection The projection containing role and operation information.
     * @return A {@link RoleOperations} domain model.
     */
    default RoleOperations toRoleOperations(RoleWithOperationsProjection projection) {
        String[] operationNames = this.extractOperationNames( projection.getOperationsInJson() );
        return RoleOperations.builder()
                .role( projection.getRoleName() )
                .operations( this.toSet(operationNames) )
                .build();
    }

}
