package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.BankCard;
import com.quathar.codebay.domain.model.type.Country;
import com.quathar.codebay.domain.model.type.CustomerType;

import com.quathar.codebay.domain.model.valueobject.PersonalInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

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
    private PersonalInfo  personalInfo;
    private Country       country;
    private Address       homeAddress;
    private Set<Address>  addresses;
    private Set<BankCard> bankCards;
    private BigDecimal    accumulatedExpenditure;
    private CustomerType  type;
    private String        comments;
    private Boolean       license;

}
