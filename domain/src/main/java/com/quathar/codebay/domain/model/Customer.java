package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.valueobject.shop.Address;
import com.quathar.codebay.domain.valueobject.PersonalInfo;
import com.quathar.codebay.domain.valueobject.shop.BankCard;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * <h1>Customer Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@SuperBuilder
@Getter
@Setter
public final class Customer extends User {

    // <<-FIELDS->>
    private PersonalInfo     personalInfo;
    private String           country;
    private Address          homeAddress;
    private Stream<Address>  addresses;
    private Stream<BankCard> bankCards;
    private BigDecimal       accumulatedExpenditure;
    private String           type;
    private String           comments;
    private Boolean          license;

}
