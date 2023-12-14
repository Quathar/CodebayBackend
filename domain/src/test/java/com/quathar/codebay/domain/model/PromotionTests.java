package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Promotion Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class PromotionTests {

    // <<-FIELD->>
    private Promotion mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Promotion.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Promotion promotion = new Promotion(
                this.mock.getId(),
                this.mock.getName(),
                this.mock.getDescription(),
                this.mock.getPeriod(),
                this.mock.getDiscount(),
                this.mock.getAudit(),
                this.mock.getProducts()
        );

        assertThat( promotion.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( promotion.getName()        ).isEqualTo( this.mock.getName() );
        assertThat( promotion.getDescription() ).isEqualTo( this.mock.getDescription() );
        assertThat( promotion.getPeriod()      ).isEqualTo( this.mock.getPeriod() );
        assertThat( promotion.getDiscount()    ).isEqualTo( this.mock.getDiscount() );
        assertThat( promotion.getProducts()    ).isEqualTo( this.mock.getProducts() );
    }

    @Test
    void setterTest() {
        Promotion promotion = Promotion.builder().build();

        promotion.setId         ( this.mock.getId() );
        promotion.setName       ( this.mock.getName() );
        promotion.setDescription( this.mock.getDescription() );
        promotion.setPeriod     ( this.mock.getPeriod() );
        promotion.setDiscount   ( this.mock.getDiscount() );
        promotion.setProducts   ( this.mock.getProducts() );

        assertThat( promotion.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( promotion.getName()        ).isEqualTo( this.mock.getName() );
        assertThat( promotion.getDescription() ).isEqualTo( this.mock.getDescription() );
        assertThat( promotion.getPeriod()      ).isEqualTo( this.mock.getPeriod() );
        assertThat( promotion.getDiscount()    ).isEqualTo( this.mock.getDiscount() );
        assertThat( promotion.getProducts()    ).isEqualTo( this.mock.getProducts() );
    }

    @Test
    void builderTest() {
        Promotion promotion = Promotion.builder()
                .id         ( this.mock.getId() )
                .name       ( this.mock.getName() )
                .description( this.mock.getDescription() )
                .period     ( this.mock.getPeriod() )
                .discount   ( this.mock.getDiscount() )
                .products   ( this.mock.getProducts() )
                .build();

        assertThat( promotion.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( promotion.getName()        ).isEqualTo( this.mock.getName() );
        assertThat( promotion.getDescription() ).isEqualTo( this.mock.getDescription() );
        assertThat( promotion.getPeriod()      ).isEqualTo( this.mock.getPeriod() );
        assertThat( promotion.getDiscount()    ).isEqualTo( this.mock.getDiscount() );
        assertThat( promotion.getProducts()    ).isEqualTo( this.mock.getProducts() );
    }

}
