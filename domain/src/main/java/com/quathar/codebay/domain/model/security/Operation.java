package com.quathar.codebay.domain.model.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * <h1>Operation Model</h1>
 *
 * @since 2024-03-20
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class Operation {

    // <<-FIELDS->>
    private UUID   id;
    private String name;

}
