package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Audit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

/**
 * <h1>Category Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Category {

    // <<-FIELDS->>
    private UUID          id;
    private String        code;
    private String        description;
    private Category      parentCategory;
    private Set<Category> childCategories;
    private Audit         audit;

}
