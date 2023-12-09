package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.type.WarningUrgency;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Warning Model</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Warning {

    // <<-FIELDS->>
    private UUID           id;
    private String         description;
    private WarningUrgency urgency;
    private LocalDateTime  processingDate;
    private Administrator  processedBy;

}
