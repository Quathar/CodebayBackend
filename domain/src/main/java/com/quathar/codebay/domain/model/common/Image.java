package com.quathar.codebay.domain.model.common;

import com.quathar.codebay.domain.model.type.ImageFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Image</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Image {

    private ImageFormat format;
    private String      fileName;
    private String      path;
    private String      description;
    private String      size;        // 300 x 400px etc...

}
