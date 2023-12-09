package com.quathar.codebay.domain.model.common;

import com.quathar.codebay.domain.model.enumerator.CardinalPoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Coordinates</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Coordinates {

    // <<-FIELDS->>
    private Integer       latitudeDegrees;
    private Integer       latitudeMinutes;
    private Integer       latitudeSeconds;
    private CardinalPoint latitudeCardinalPoint;
    private Integer       longitudeDegrees;
    private Integer       longitudeMinutes;
    private Integer       longitudeSeconds;
    private CardinalPoint longitudeCardinalPoint;

}
