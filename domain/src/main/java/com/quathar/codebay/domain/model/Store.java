package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Coordinates;
import com.quathar.codebay.domain.model.common.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * <h1>Store Model</h1>
 *
 * @since 2023-04-14
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Store {

    // <<-FIELDS->>
    private UUID        id;
    private Address     address;
    private Image       image;
    private Coordinates coordinates;

}
