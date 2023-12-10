package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.ModelProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Shopping Cart Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class ShoppingCartTests {

    // <<-CONSTANTS->>
    private static final Integer INTEGER = 0;
    private static final BigDecimal BIG_DECIMAL = BigDecimal.ONE;

    // <<-FIELDS->>
    private UUID id;
    private Customer customer;
    private LocalDateTime creationDate;
    private Product product;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.id           = UUID.randomUUID();
        this.customer     = ModelProvider.getInstance(Customer.class);
        this.creationDate = LocalDateTime.now();
        this.product      = ModelProvider.getInstance(Product.class);
    }

    @Test
    void fullArgsConstructorTest() {
        ShoppingCart.Detail detail = new ShoppingCart.Detail(
                this.product,
                INTEGER
        );

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getUnits()   ).isEqualTo( INTEGER );

        Set<ShoppingCart.Detail> details = Set.of(detail);

        ShoppingCart shoppingCart = new ShoppingCart(
                this.id,
                this.customer,
                this.creationDate,
                details,
                BIG_DECIMAL
        );

        assertThat( shoppingCart.getId()           ).isEqualTo( this.id );
        assertThat( shoppingCart.getCustomer()     ).isEqualTo( this.customer );
        assertThat( shoppingCart.getCreationDate() ).isEqualTo( this.creationDate );
        assertThat( shoppingCart.getDetails()      ).isEqualTo( details );
        assertThat( shoppingCart.getPrice()        ).isEqualTo( BIG_DECIMAL );
    }

    @Test
    void setterTest() {
        ShoppingCart.Detail detail = ShoppingCart.Detail.builder().build();

        detail.setProduct( this.product );
        detail.setUnits  ( INTEGER );

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getUnits()   ).isEqualTo( INTEGER );

        Set<ShoppingCart.Detail> details = Set.of(detail);

        ShoppingCart shoppingCart = ShoppingCart.builder().build();

        shoppingCart.setId          ( this.id );
        shoppingCart.setCustomer    ( this.customer );
        shoppingCart.setCreationDate( this.creationDate );
        shoppingCart.setDetails     ( details );
        shoppingCart.setPrice       ( BIG_DECIMAL );

        assertThat( shoppingCart.getId()           ).isEqualTo( this.id );
        assertThat( shoppingCart.getCustomer()     ).isEqualTo( this.customer );
        assertThat( shoppingCart.getCreationDate() ).isEqualTo( this.creationDate );
        assertThat( shoppingCart.getDetails()      ).isEqualTo( details );
        assertThat( shoppingCart.getPrice()        ).isEqualTo( BIG_DECIMAL );
    }

    @Test
    void builderTest() {
        ShoppingCart.Detail detail = ShoppingCart.Detail.builder()
                .product( this.product )
                .units( INTEGER )
                .build();

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getUnits()   ).isEqualTo( INTEGER );

        Set<ShoppingCart.Detail> details = Set.of(detail);

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .id          ( this.id )
                .customer    ( this.customer )
                .creationDate( this.creationDate )
                .details     ( details )
                .price       ( BIG_DECIMAL )
                .build();

        assertThat( shoppingCart.getId()           ).isEqualTo( this.id );
        assertThat( shoppingCart.getCustomer()     ).isEqualTo( this.customer );
        assertThat( shoppingCart.getCreationDate() ).isEqualTo( this.creationDate );
        assertThat( shoppingCart.getDetails()      ).isEqualTo( details );
        assertThat( shoppingCart.getPrice()        ).isEqualTo( BIG_DECIMAL );
    }

}
