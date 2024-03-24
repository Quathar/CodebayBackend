package com.quathar.codebay.domain.model.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * <h1>Role Operations Model</h1>
 *
 * @since 2024-03-22
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class RoleOperations {

    // <<-FIELDS->>
    private String      role;
    private Set<String> operations;

}
