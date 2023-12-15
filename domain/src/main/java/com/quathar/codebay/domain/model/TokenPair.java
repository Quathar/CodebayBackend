package com.quathar.codebay.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Token Pair Model</h1>
 *
 * @since 2023-12-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class TokenPair {

    // <<-FIELDS->>
    private String type;
    private String refreshToken;
    private String accessToken;

}
