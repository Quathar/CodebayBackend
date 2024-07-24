package com.quathar.codebay.infra.jpa.entity.option;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * <h1>Base Option</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseOption {

    // <<-FIELDS->>
    @Id
    private String code;

    @Column(nullable = false)
    private String text;

}
