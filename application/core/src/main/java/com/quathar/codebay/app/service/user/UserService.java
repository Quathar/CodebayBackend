package com.quathar.codebay.app.service.user;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.port.in.user.UpdateByUsernameUseCasePort;

import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * <h1>User Service</h1>
 *
 * @see CommonUserService
 * @see UpdateByUsernameUseCasePort
 * @see User
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class UserService
       extends     CommonUserService<User>
       implements  UpdateByUsernameUseCasePort<User> {

    // <<-FIELD->>
    @NonNull private final UpdateByUsernameUseCasePort<User> updateByUsernameUseCase;

    // <<-METHOD->>
    public User updateByUsername(User userToUpdate) {
        return this.updateByUsernameUseCase.updateByUsername(userToUpdate);
    }

}
