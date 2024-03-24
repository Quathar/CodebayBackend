package com.quathar.codebay.domain.model.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * <h1>Granted Permission Model</h1>
 *
 * @since 2024-03-20
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class GrantedPermission {

    // <<-FIELDS->>
    private UUID      id;
    private Role      role;
    private Operation operation;

}
