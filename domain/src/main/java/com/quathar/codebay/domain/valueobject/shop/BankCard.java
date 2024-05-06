package com.quathar.codebay.domain.valueobject.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <h1>Bank Card Value Object</h1>
 *
 * @since 2023-05-13
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public final class BankCard {

    // <<-FIELDS->>
    private String    brand; // [Visa, Mastercard, Others]
    private String    name;
    private String    number;
    private LocalDate expirationDate;
    private String    ccv;

}
