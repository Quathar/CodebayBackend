package com.quathar.codebay.infra.jpa.entity.shop;

import com.quathar.codebay.infra.jpa.embeddable.AuditEmbeddable;
import com.quathar.codebay.infra.jpa.embeddable.shop.ImageEmbeddable;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Product Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.Product
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Product")
@NoArgsConstructor
@Getter
@Setter
public final class ProductEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 350)
    private String description;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @ElementCollection
    @CollectionTable(name = "product_images",
            joinColumns = @JoinColumn(name = "product_id"),
            foreignKey  = @ForeignKey(name = "FK_product_images_productId"))
    private Set<ImageEmbeddable> productImages;

    @Column(nullable = false, scale = 2)
    private BigDecimal price;

    @Column(name = "rating_number")
    private Integer ratingNumber;

    private BigDecimal rating;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitsSold;

    @Column(nullable = false)
    private Integer upperLimit;

    @Column(nullable = false)
    private Integer lowerLimit;

    @Column(nullable = false)
    private BigDecimal totalEarnings;

    @Column(nullable = false)
    private Boolean onSale;

    @Column(nullable = false)
    private Boolean onOffer;

    @Column(nullable = false)
    private Boolean isNew;

    private BigDecimal discount;

    private String comments;

    @Embedded
    private AuditEmbeddable audit;

}
