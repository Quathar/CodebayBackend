package com.quathar.codebay.domain.model.common;

import com.quathar.codebay.domain.model.type.CardBrand;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <h1>Bank Card</h1>
 *
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class BankCard {

    // <<-FIELDS->>
    private CardBrand brand; // [Visa, Mastercard, Others]
    private String    name;
    private String    number;
    private LocalDate expirationDate;
    private String    ccv;

}
