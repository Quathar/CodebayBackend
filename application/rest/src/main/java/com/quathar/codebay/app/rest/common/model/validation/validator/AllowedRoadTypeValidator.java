package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedRoadType;
import com.quathar.codebay.domain.port.out.option.RoadTypeRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.RoadType;

import org.springframework.stereotype.Component;

/**
 * <h1>Allowed Road Type Validator</h1>
 *
 * @see AllowedRoadType
 * @see AllowedBaseOptionValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Component
public final class AllowedRoadTypeValidator
       extends     AllowedBaseOptionValidator<RoadType, AllowedRoadType> {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link AllowedRoadTypeValidator}
     * with the specified {@link RoadTypeRepositoryPort}.
     *
     * @param roadTypeRepositoryPort The {@link RoadType} repository port.
     */
    public AllowedRoadTypeValidator(RoadTypeRepositoryPort roadTypeRepositoryPort) {
        super(roadTypeRepositoryPort);
    }

}
