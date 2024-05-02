package com.quathar.codebay.infra.jpa.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Role Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.security.Role
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Role")
@NoArgsConstructor
@Getter
@Setter
public final class RoleEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<GrantedPermissionEntity> grantedPermissions;

}
