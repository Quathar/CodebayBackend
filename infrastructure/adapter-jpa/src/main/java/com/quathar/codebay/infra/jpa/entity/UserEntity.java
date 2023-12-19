package com.quathar.codebay.infra.jpa.entity;

import com.quathar.codebay.domain.model.enumerator.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    private Integer successfulAuth;

    @Column(nullable = false)
    private Integer failedAuth;

    private LocalDateTime lastConnection;

    private LocalDateTime releaseBlock;

    @Column(nullable = false)
    private UserStatus status;

    // TODO: Add all the fields necessary for persistence

}
