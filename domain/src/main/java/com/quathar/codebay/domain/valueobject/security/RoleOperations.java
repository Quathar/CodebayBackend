package com.quathar.codebay.domain.valueobject.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

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
public final class RoleOperations {

    // <<-FIELDS->>
    private String         role;
    private Stream<String> operations;

}
