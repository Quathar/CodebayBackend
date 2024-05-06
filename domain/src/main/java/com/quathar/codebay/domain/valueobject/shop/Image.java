package com.quathar.codebay.domain.valueobject.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Image Value Object</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class Image {

    // <<-FIELDS->>
    private String format;
    private String fileName;
    private String path;
    private String description;
    private String size;        // 300 x 400px etc...

}
