package com.quathar.codebay.infra.jpa.entity.shop;

import com.quathar.codebay.infra.jpa.entity.CustomerEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * <h1>Wish List Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.WishList
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Wish_List")
@NoArgsConstructor
@Getter
@Setter
public final class WishListEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "wishlist_product",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            foreignKey  = @ForeignKey(name = "FK_wishlist-product_wishlist"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            inverseForeignKey  = @ForeignKey(name = "FK_wishlist-product_product"))
    private List<ProductEntity> products;

}
