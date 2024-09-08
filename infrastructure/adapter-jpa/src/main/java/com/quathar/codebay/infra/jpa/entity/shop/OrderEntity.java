package com.quathar.codebay.infra.jpa.entity.shop;

import com.quathar.codebay.infra.jpa.entity.user.CustomerEntity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Order Entity</h1>
 *
 * @see com.quathar.codebay.domain.model.shop.Order
 * @since 2023-03-27
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Orders")
@NoArgsConstructor
@Getter
@Setter
public final class OrderEntity {

    // <<-FIELDS->>
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @ElementCollection
    @CollectionTable(name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            foreignKey  = @ForeignKey(name = "FK_order-details_order_id"))
    private List<OrderDetailEmbeddable> details;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private String status;

}
