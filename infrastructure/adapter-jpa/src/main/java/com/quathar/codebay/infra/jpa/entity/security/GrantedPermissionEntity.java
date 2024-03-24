package com.quathar.codebay.infra.jpa.entity.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * <h1>Granted Permission Entity</h1>
 *
 * @since 2024-03-21
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Granted_Permission")
@NoArgsConstructor
@Getter
@Setter
public class GrantedPermissionEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private OperationEntity operation;

}
