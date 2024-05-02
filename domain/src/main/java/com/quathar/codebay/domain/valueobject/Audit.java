package com.quathar.codebay.domain.valueobject;

import com.quathar.codebay.domain.model.Administrator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <h1>Audit Value Object</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Audit {

    // <<-FIELDS->>
    private LocalDateTime creationDate;
    private Administrator createdBy;
    private LocalDateTime modificationDate;
    private Administrator modificationBy;
    private LocalDateTime deletionDate;
    private Administrator deletedBy;

}
