package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.enumerator.UserStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
public class User {

    // <<-FIELDS->>
    private UUID          id;
    private String        username;
    private String        password; // hashed password
    private String        nickname;
    private String        email;
    private Integer       successfulAuth;
    private Integer       failedAuth;
    private LocalDateTime lastConnection;
    private LocalDateTime releaseBlock;
    private UserStatus    status;
    private Audit         audit;

}
