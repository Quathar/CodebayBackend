package com.quathar.codebay.infra.jpa.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Phone Embeddable</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class PhoneEmbeddable {

    // <<-FIELDS->>
    @Column(nullable = false)
    private String countryCode;

    private String number;

}
