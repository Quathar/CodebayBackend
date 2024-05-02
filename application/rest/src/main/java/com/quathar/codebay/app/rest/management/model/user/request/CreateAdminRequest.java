package com.quathar.codebay.app.rest.management.model.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <h1>Create Administrator Request</h1>
 *
 * @param username     The username of the user. Cannot be null or blank.
 * @param password     The password of the user. Cannot be null or blank. Should adhere to a specific pattern.
 * @param nickname     The nickname of the user. Cannot be null or blank.
 * @param email        The email address of the user. Cannot be null or blank. Should adhere to a specific pattern.
 * @param documentType The type of document. Cannot be null or blank.
 * @param document     The document number of the user. Cannot be null or blank.
 * @param name         The name of the user. Cannot be null or blank.
 * @param surnames     The surnames of the user. Cannot be null or blank.
 * @param gender       The gender of the user. Cannot be null or blank.
 * @param birthdate    The birthdate of the user. Cannot be null or blank.
 * @param countryCode  The country code of the user's phone number. Cannot be null or blank.
 * @param number       The phone number of the user. Cannot be null or blank.
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public record CreateAdminRequest(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @NotNull
        @NotBlank
        String nickname,
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email,
        @NotNull
        @NotBlank
        String documentType,
        @NotNull
        @NotBlank
        String document,
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String surnames,
        @NotNull
        @NotBlank
        String gender,
        @NotNull
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate birthdate,
        @NotNull
        @NotBlank
        String countryCode,
        @NotNull
        @NotBlank
        String number
) {}
