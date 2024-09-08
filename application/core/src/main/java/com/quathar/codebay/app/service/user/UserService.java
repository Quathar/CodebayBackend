package com.quathar.codebay.app.service.user;

import com.quathar.codebay.domain.model.User;

import lombok.experimental.SuperBuilder;

/**
 * <h1>User Service</h1>
 *
 * @see CommonUserService
 * @see User
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class UserService
       extends     CommonUserService<User> {
}
