package com.quathar.codebay.domain.model.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <h1>Period</h1>
 *
 * @since 2023-04-14
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Period {

    // <<-FIELDS->>
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
