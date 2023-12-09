package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.BankCard;
import com.quathar.codebay.domain.model.enumerator.Gender;
import com.quathar.codebay.domain.model.type.Country;
import com.quathar.codebay.domain.model.type.CustomerType;
import com.quathar.codebay.domain.model.type.DocumentType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Customer Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Customer {

    // <<-FIELDS->>
    private UUID          id;
    private User          user;
    private DocumentType  documentType;
    private String        document;
    private String        name;
    private String        surnames;
    private Gender        gender;
    private LocalDate     birthdate;
    private Country       country;
    private String        phoneNumber;
    private Address       homeAddress;
    private Set<Address>  addresses;
    private Set<BankCard> bankCards;
    private BigDecimal    accumulatedExpenditure;
    private CustomerType  type;
    private String        comments;
    private Boolean       license;
    private Audit         audit;

}
