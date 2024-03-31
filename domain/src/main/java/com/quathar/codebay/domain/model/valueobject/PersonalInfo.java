package com.quathar.codebay.domain.model.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <h1>Personal Info Value Object</h1>
 *
 * @since 2024-03-30
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class PersonalInfo {

    // <<-FIELDS->>
    private Document  document;
    private String    name;
    private String    surnames;
    private String    gender;
    private LocalDate birthdate;
    private Phone     phone;

}
