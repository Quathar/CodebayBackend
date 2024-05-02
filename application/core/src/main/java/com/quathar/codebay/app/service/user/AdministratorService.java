package com.quathar.codebay.app.service.user;

import com.quathar.codebay.domain.model.Administrator;

import lombok.experimental.SuperBuilder;

/**
 * <h1>Administrator Service</h1>
 *
 * @see CommonUserService
 * @see Administrator
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@SuperBuilder(builderMethodName = "setup", buildMethodName = "seal")
public final class AdministratorService extends CommonUserService<Administrator> {
}
