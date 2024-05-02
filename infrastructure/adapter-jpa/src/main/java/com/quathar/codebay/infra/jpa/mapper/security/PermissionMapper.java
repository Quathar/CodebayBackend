package com.quathar.codebay.infra.jpa.mapper.security;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.port.out.mapper.MapperServicePort;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;
import com.quathar.codebay.infra.jpa.entity.security.GrantedPermissionEntity;
import com.quathar.codebay.infra.jpa.projection.RoleWithOperationsProjection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * <h1>Permission Mapper</h1>
 *
 * @see MapperServicePort
 * @see GrantedPermission
 * @see GrantedPermissionEntity
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Mapper(componentModel = SPRING, uses = OperationMapper.class, unmappedTargetPolicy = IGNORE)
public interface PermissionMapper extends MapperServicePort<GrantedPermission, GrantedPermissionEntity> {

    @Override
    @Mapping(target = "role.grantedPermissions", ignore = true)
    GrantedPermission toModel(GrantedPermissionEntity entity);

    /**
     * Extracts operation names from a JSON string.
     *
     * @param operationsInJson The JSON string containing operation names.
     * @return An array of operation names.
     */
    private String[] extractOperationNames(String operationsInJson) {
        // Input is something like this: {..., ..., ...}
        var beginIndex = 1;
        var endIndex   = operationsInJson.length() - 1;
        return operationsInJson.substring(beginIndex, endIndex).split(",");
    }

    /**
     * Converts an array of operation names to a stream.
     *
     * @param operationsNames The array of operation names.
     * @return A stream of operation names.
     */
    private java.util.stream.Stream<String> toStream(String[] operationsNames) {
        return java.util.Arrays.stream(operationsNames)
                .map(String::trim)
                .map(part -> part.replace("\"", ""));
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
                .operations( this.toStream(operationNames) )
                .build();
    }

}
