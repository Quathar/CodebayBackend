package com.quathar.codebay.infra.jpa.entity.shop;

import com.quathar.codebay.infra.jpa.entity.user.CustomerEntity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Shopping Cart Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.ShoppingCart
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Shopping_Cart")
@NoArgsConstructor
@Getter
@Setter
public final class ShoppingCartEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ElementCollection
    @CollectionTable(name = "cart_details",
            joinColumns = @JoinColumn(name = "cart_id"),
            foreignKey  = @ForeignKey(name = "FK_cart-details_cart_id"))
    private List<CartDetailEmbeddable> details;

}
