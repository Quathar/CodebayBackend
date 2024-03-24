package com.quathar.codebay.domain.model.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * <h1>Role Model</h1>
 *
 * @since 2024-03-20
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Role {

    // <<-FIELDS->>
    private UUID   id;
    private String name;
    private String description;

}
