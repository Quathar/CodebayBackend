package com.quathar.codebay.domain.model.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Document Value Object</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Document {

    // <<-FIELDS->>
    private String type;
    private String content;

}
