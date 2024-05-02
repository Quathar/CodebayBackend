package com.quathar.codebay.infra.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Document Embeddable</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class DocumentEmbeddable {

    // <<-FIELDS->>
    @Column(nullable = false)
    private String type;

    @Column(nullable = false, unique = true)
    private String content;

}
