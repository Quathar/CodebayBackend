package com.quathar.codebay.infra.jpa.entity.user;

import com.quathar.codebay.infra.jpa.embeddable.PersonalInfoEmbeddable;
import com.quathar.codebay.infra.jpa.embeddable.shop.AddressEmbeddable;
import com.quathar.codebay.infra.jpa.embeddable.shop.BankCardEmbeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

/**
 * <h1>Customer Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.Customer
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Customer")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@NoArgsConstructor
@Getter
@Setter
public final class CustomerEntity extends UserEntity {

    // <<-FIELDS->>
    @Embedded
    private PersonalInfoEmbeddable personalInfo;

    @Column(nullable = false)
    private String country;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "address_name")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number"))
    })
    private AddressEmbeddable homeAddress;

    @ElementCollection
    @CollectionTable(name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            foreignKey  = @ForeignKey(name = "FK_addresses_customer_id"))
    private Set<AddressEmbeddable> addresses;

    @ElementCollection
    @CollectionTable(name = "customer_bankcard",
            joinColumns = @JoinColumn(name = "customer_id"),
            foreignKey  = @ForeignKey(name = "FK_bankcards_customer_id"))
    private Set<BankCardEmbeddable> bankCards;

    @Column(nullable = false)
    private BigDecimal accumulatedExpenditure;

    @Column(nullable = false)
    private String type;

    private String comments;

    @Column(nullable = false)
    private Boolean license;

}
