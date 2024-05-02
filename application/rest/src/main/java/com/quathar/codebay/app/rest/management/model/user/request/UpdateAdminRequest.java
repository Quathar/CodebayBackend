package com.quathar.codebay.app.rest.management.model.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <h1>Update Administrator Request</h1>
 *
 * @param username     The username of the user. Cannot be blank.
 * @param password     The password of the user. Cannot be blank. Should adhere to a specific pattern.
 * @param nickname     The nickname of the user. Cannot be blank.
 * @param email        The email address of the user. Cannot be blank. Should adhere to a specific pattern.
 * @param documentType The type of document. Cannot be blank.
 * @param document     The document number of the user. Cannot be blank.
 * @param name         The name of the user. Cannot be blank.
 * @param surnames     The surnames of the user. Cannot be blank.
 * @param gender       The gender of the user. Cannot be blank.
 * @param birthdate    The birthdate of the user. Cannot be blank.
 * @param countryCode  The country code of the user's phone number. Cannot be blank.
 * @param number       The phone number of the user. Cannot be blank.
 *
 * @since 2024-04-02
 * @version 1.0
 * @author Q
 */
public record UpdateAdminRequest(
        @NotBlank
        String username,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{12,128}$")
        String password,
        @NotBlank
        String nickname,
        @NotBlank
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")
        String email,
        @NotBlank
        String documentType,
        @NotBlank
        String document,
        @NotBlank
        String name,
        @NotBlank
        String surnames,
        @NotBlank
        String gender,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate birthdate,
        @NotBlank
        String countryCode,
        @NotBlank
        String number
) {}
