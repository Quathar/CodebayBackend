package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.valueobject.PersonalInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * <h1>Administrator Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@SuperBuilder
@Getter
@Setter
public class Administrator extends User {

    // <<-FIELD->>
    private PersonalInfo personalInfo;

}
