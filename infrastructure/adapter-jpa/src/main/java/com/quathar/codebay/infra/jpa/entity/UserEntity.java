package com.quathar.codebay.infra.jpa.entity;

import com.quathar.codebay.infra.jpa.entity.security.RoleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>User Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.User
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @Column(name = "successful_auth", nullable = false)
    private Integer successfulAuth;

    @Column(name = "failed_auth", nullable = false)
    private Integer failedAuth;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "password_expiration_date", nullable = false)
    private LocalDateTime passwordExpirationDate;

    @Column(name = "end_block_date")
    private LocalDateTime endBlockDate;

    @Column(name = "last_connection", nullable = false)
    private LocalDateTime lastConnection;

    // TODO: enable Audit

}
