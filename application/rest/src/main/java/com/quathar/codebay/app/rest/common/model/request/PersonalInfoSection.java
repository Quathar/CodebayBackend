package com.quathar.codebay.app.rest.common.model.request;

import jakarta.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * <h1>Personal Information Section</h1>
 *
 * @param document  the document section containing document-related information
 * @param name      the name of the person
 * @param surnames  the surnames of the person
 * @param gender    the gender of the person
 * @param birthdate the birthdate of the person in the format yyyy/MM/dd
 * @param phone     the phone section containing phone-related information
 *
 * @see com.quathar.codebay.domain.valueobject.PersonalInfo
 * @since 2023-04-21
 * @version 1.0
 * @author Q
 */
public record PersonalInfoSection(
        DocumentSection document,
        @NotBlank
        String name,
        @NotBlank
        String surnames,
        @NotBlank
        String gender,
        @NotBlank
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        LocalDate birthdate,
        PhoneSection phone
) {}
