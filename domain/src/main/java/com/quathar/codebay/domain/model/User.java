package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.valueobject.Audit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>User Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@SuperBuilder
@Getter
@Setter
public sealed class User permits Administrator {

    // <<-FIELDS->>
    private UUID          id;
    private String        username;
    private String        password;
    private String        nickname;
    private String        email;
    private String        status;
    private Role          role;
    private Integer       successfulAuth;
    private Integer       failedAuth;
    private LocalDateTime passwordExpirationDate;
    private LocalDateTime endBlockDate;
    private LocalDateTime lastConnection;
    private Audit         audit;

}
