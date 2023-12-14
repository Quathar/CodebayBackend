package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;
import com.quathar.codebay.domain.model.common.Period;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Catalog Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class CatalogTests {

    // <<-CONSTANT->>
    private static final BigDecimal BIG_DECIMAL = BigDecimal.ONE;

    // <<-FIELDS->>
    private UUID id;
    private Supplier supplier;
    private Period period;
    private Product product;

    // <<-TEST->>
    @BeforeEach
    void setUp() {
        this.id       = UUID.randomUUID();
        this.supplier = MockProvider.getInstance(Supplier.class);
        this.period   = MockProvider.getInstance(Period.class);
        this.product  = MockProvider.getInstance(Product.class);;
    }

    @Test
    void fullArgsConstructorTest() {
        Catalog.Detail detail = new Catalog.Detail(
                this.product,
                BIG_DECIMAL
        );

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getPrice()   ).isEqualTo( BIG_DECIMAL );

        Set<Catalog.Detail> details = Set.of(detail);

        Catalog catalog = new Catalog(
                this.id,
                this.supplier,
                this.period,
                details
        );

        assertThat( catalog.getId()       ).isEqualTo( this.id );
        assertThat( catalog.getSupplier() ).isEqualTo( this.supplier );
        assertThat( catalog.getPeriod()   ).isEqualTo( this.period );
        assertThat( catalog.getDetails()  ).isEqualTo( details );
    }

    @Test
    void setterTest() {
        Catalog.Detail detail = Catalog.Detail.builder().build();

        detail.setProduct( this.product );
        detail.setPrice  ( BIG_DECIMAL );

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getPrice()   ).isEqualTo( BIG_DECIMAL );

        Set<Catalog.Detail> details = Set.of(detail);

        Catalog catalog = Catalog.builder().build();

        catalog.setId      ( this.id );
        catalog.setSupplier( this.supplier );
        catalog.setPeriod  ( this.period );
        catalog.setDetails ( details );

        assertThat( catalog.getId()       ).isEqualTo( this.id );
        assertThat( catalog.getSupplier() ).isEqualTo( this.supplier );
        assertThat( catalog.getPeriod()   ).isEqualTo( this.period );
        assertThat( catalog.getDetails()  ).isEqualTo( details );
    }

    @Test
    void builderTest() {
        Catalog.Detail detail = Catalog.Detail.builder()
                .product( this.product )
                .price  ( BIG_DECIMAL )
                .build();

        assertThat( detail.getProduct() ).isEqualTo( this.product );
        assertThat( detail.getPrice()   ).isEqualTo( BIG_DECIMAL );

        Set<Catalog.Detail> details = Set.of(detail);

        Catalog catalog = Catalog.builder()
                .id      ( this.id )
                .supplier( this.supplier )
                .period  ( this.period )
                .details ( details )
                .build();

        assertThat( catalog.getId()       ).isEqualTo( this.id );
        assertThat( catalog.getSupplier() ).isEqualTo( this.supplier );
        assertThat( catalog.getPeriod()   ).isEqualTo( this.period );
        assertThat( catalog.getDetails()  ).isEqualTo( details );
    }

}
