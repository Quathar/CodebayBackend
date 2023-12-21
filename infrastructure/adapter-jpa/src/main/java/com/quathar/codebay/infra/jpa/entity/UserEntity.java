package com.quathar.codebay.infra.jpa.entity;

import com.quathar.codebay.domain.model.enumerator.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.ORDINAL;

/**
 * <h1>User Entity</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @Column(name = "successful_auth", nullable = false)
    private Integer successfulAuth;

    @Column(name = "failed_auth", nullable = false)
    private Integer failedAuth;

    @Column(name = "last_connection")
    private LocalDateTime lastConnection;

    @Column(name = "release_block")
    private LocalDateTime releaseBlock;

    @Enumerated(ORDINAL)
    @Column(nullable = false)
    private UserStatus status;

    // TODO: Add all the fields necessary for persistence

}
