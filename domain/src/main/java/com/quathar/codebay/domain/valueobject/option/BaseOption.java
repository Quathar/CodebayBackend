package com.quathar.codebay.domain.valueobject.option;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * <h1>Base Option Value Object</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@SuperBuilder
@Getter
@Setter
public abstract class BaseOption {

    // <<-FIELDS->>
    private String code;
    private String text;

}
