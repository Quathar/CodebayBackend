package com.quathar.codebay.infra.jpa.embeddable;

import com.quathar.codebay.infra.jpa.entity.AdministratorEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <h1>Audit Embeddable</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Embeddable
@NoArgsConstructor
@Getter
@Setter
public final class AuditEmbeddable {

    // <<-FIELDS->>
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private AdministratorEntity createdBy;

    @Column(name = "modification_date")
    private LocalDateTime modificationDate;

    @ManyToOne
    @JoinColumn(name = "modification_by")
    private AdministratorEntity modificationBy;

    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;

    @ManyToOne
    @JoinColumn(name = "deleted_by")
    private AdministratorEntity deletedBy;

}
