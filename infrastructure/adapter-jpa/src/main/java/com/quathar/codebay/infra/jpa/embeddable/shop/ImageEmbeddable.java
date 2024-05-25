package com.quathar.codebay.infra.jpa.embeddable.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Image Embeddable</h1>
 *
 * @see com.quathar.codebay.domain.valueobject.shop.Image
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class ImageEmbeddable {

    // <<-FIELDS->>
    @Column(nullable = false)
    private String format;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String path;

    private String description;

    @Column(nullable = false)
    private String size;

}
