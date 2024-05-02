package com.quathar.codebay.infra.jpa.embeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <h1>Personal Info Embeddable</h1>
 *
 * @see DocumentEmbeddable
 * @see PhoneEmbeddable
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class PersonalInfoEmbeddable {

    // <<-FIELDS->>
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type",    column = @Column(name = "document_type")),
            @AttributeOverride(name = "content", column = @Column(name = "document"))
    })
    private DocumentEmbeddable document;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surnames;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "phone_code")),
            @AttributeOverride(name = "number",      column = @Column(name = "phone_number"))
    })
    private PhoneEmbeddable phone;

}
