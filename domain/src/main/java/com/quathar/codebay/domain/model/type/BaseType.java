package com.quathar.codebay.domain.model.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Base Type</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public abstract class BaseType {

    // <<-FIELDS->>
    private String code;
    private String value;

}
