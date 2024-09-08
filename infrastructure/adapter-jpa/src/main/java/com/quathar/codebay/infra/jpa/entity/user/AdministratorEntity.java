package com.quathar.codebay.infra.jpa.entity.user;

import com.quathar.codebay.infra.jpa.embeddable.PersonalInfoEmbeddable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Administrator Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.Administrator
 * @see UserEntity
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Administrator")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@NoArgsConstructor
@Getter
@Setter
public final class AdministratorEntity extends UserEntity {

    // <<-FIELD->>
    @Embedded
    private PersonalInfoEmbeddable personalInfo;

}
