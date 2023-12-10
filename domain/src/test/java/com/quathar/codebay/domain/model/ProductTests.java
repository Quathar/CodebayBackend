package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.ModelProvider;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.Image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Product Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class ProductTests {

    // <<-CONSTANTS->>
    private static final String CODE = "X382KD";
    private static final String NAME = "Test Product";
    private static final String DESCRIPTION = "A test product";
    private static final String BRAND = "ProductMasters";
    private static final String MODEL = "ProductA";
    private static final BigDecimal PRICE = BigDecimal.valueOf(6.25);;
    private static final Integer RATING_NUMBER = 2;
    private static final BigDecimal RATING = BigDecimal.valueOf(2.5);;
    private static final Integer STOCK = 18;
    private static final Integer UNITS_SOLD = 2;
    private static final Integer UPPER_LIMIT = 10;
    private static final Integer LOWER_LIMIT = 5;
    private static final BigDecimal TOTAL_EARNINGS = BigDecimal.valueOf(12.5);
    private static final Boolean ON_SALE = true;
    private static final Boolean ON_OFFER = false;
    private static final Boolean IS_NEW = true;
    private static final BigDecimal DISCOUNT = BigDecimal.ZERO;
    private static final String COMMENTS = "Comments";

    // <<-FIELDS->>
    private UUID id;
    private Set<Image> productImages;
    private Audit audit;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.id            = UUID.randomUUID();
        this.productImages = Set.of(ModelProvider.getInstance(Image.class));
        this.audit         = ModelProvider.getInstance(Audit.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Product product = new Product(
                this.id,
                CODE,
                NAME,
                DESCRIPTION,
                BRAND,
                MODEL,
                this.productImages,
                PRICE,
                RATING_NUMBER,
                RATING,
                STOCK,
                UNITS_SOLD,
                UPPER_LIMIT,
                LOWER_LIMIT,
                TOTAL_EARNINGS,
                ON_SALE,
                ON_OFFER,
                IS_NEW,
                DISCOUNT,
                COMMENTS,
                this.audit
        );

        assertThat( product.getId()            ).isEqualTo( this.id );
        assertThat( product.getCode()          ).isEqualTo( CODE );
        assertThat( product.getName()          ).isEqualTo( NAME );
        assertThat( product.getDescription()   ).isEqualTo( DESCRIPTION );
        assertThat( product.getBrand()         ).isEqualTo( BRAND );
        assertThat( product.getModel()         ).isEqualTo( MODEL );
        assertThat( product.getProductImages() ).isEqualTo( this.productImages );
        assertThat( product.getPrice()         ).isEqualTo( PRICE );
        assertThat( product.getRatingNumber()  ).isEqualTo( RATING_NUMBER );
        assertThat( product.getRating()        ).isEqualTo( RATING );
        assertThat( product.getStock()         ).isEqualTo( STOCK );
        assertThat( product.getUnitsSold()     ).isEqualTo( UNITS_SOLD );
        assertThat( product.getUpperLimit()    ).isEqualTo( UPPER_LIMIT );
        assertThat( product.getLowerLimit()    ).isEqualTo( LOWER_LIMIT );
        assertThat( product.getTotalEarnings() ).isEqualTo( TOTAL_EARNINGS );
        assertThat( product.getOnSale()        ).isEqualTo( ON_SALE );
        assertThat( product.getOnOffer()       ).isEqualTo( ON_OFFER );
        assertThat( product.getIsNew()         ).isEqualTo( IS_NEW );
        assertThat( product.getDiscount()      ).isEqualTo( DISCOUNT );
        assertThat( product.getComments()      ).isEqualTo( COMMENTS );
        assertThat( product.getAudit()         ).isEqualTo( this.audit );
    }

    @Test
    void setterTest() {
        Product product = Product.builder().build();

        product.setId           ( this.id );
        product.setCode         ( CODE );
        product.setName         ( NAME );
        product.setDescription  ( DESCRIPTION );
        product.setBrand        ( BRAND );
        product.setModel        ( MODEL );
        product.setProductImages( this.productImages );
        product.setPrice        ( PRICE );
        product.setRatingNumber ( RATING_NUMBER );
        product.setRating       ( RATING );
        product.setStock        ( STOCK );
        product.setUnitsSold    ( UNITS_SOLD );
        product.setUpperLimit   ( UPPER_LIMIT );
        product.setLowerLimit   ( LOWER_LIMIT );
        product.setTotalEarnings( TOTAL_EARNINGS );
        product.setOnSale       ( ON_SALE );
        product.setOnOffer      ( ON_OFFER );
        product.setIsNew        ( IS_NEW );
        product.setDiscount     ( DISCOUNT );
        product.setComments     ( COMMENTS );
        product.setAudit        ( this.audit );

        assertThat( product.getId()            ).isEqualTo( this.id );
        assertThat( product.getCode()          ).isEqualTo( CODE );
        assertThat( product.getName()          ).isEqualTo( NAME );
        assertThat( product.getDescription()   ).isEqualTo( DESCRIPTION );
        assertThat( product.getBrand()         ).isEqualTo( BRAND );
        assertThat( product.getModel()         ).isEqualTo( MODEL );
        assertThat( product.getProductImages() ).isEqualTo( this.productImages );
        assertThat( product.getPrice()         ).isEqualTo( PRICE );
        assertThat( product.getRatingNumber()  ).isEqualTo( RATING_NUMBER );
        assertThat( product.getRating()        ).isEqualTo( RATING );
        assertThat( product.getStock()         ).isEqualTo( STOCK );
        assertThat( product.getUnitsSold()     ).isEqualTo( UNITS_SOLD );
        assertThat( product.getUpperLimit()    ).isEqualTo( UPPER_LIMIT );
        assertThat( product.getLowerLimit()    ).isEqualTo( LOWER_LIMIT );
        assertThat( product.getTotalEarnings() ).isEqualTo( TOTAL_EARNINGS );
        assertThat( product.getOnSale()        ).isEqualTo( ON_SALE );
        assertThat( product.getOnOffer()       ).isEqualTo( ON_OFFER );
        assertThat( product.getIsNew()         ).isEqualTo( IS_NEW );
        assertThat( product.getDiscount()      ).isEqualTo( DISCOUNT );
        assertThat( product.getComments()      ).isEqualTo( COMMENTS );
        assertThat( product.getAudit()         ).isEqualTo( this.audit );
    }

    @Test
    void builderTest() {
        Product product = Product.builder()
                .id           ( this.id )
                .code         ( CODE )
                .name         ( NAME )
                .description  ( DESCRIPTION )
                .brand        ( BRAND )
                .model        ( MODEL )
                .productImages( this.productImages )
                .price        ( PRICE )
                .ratingNumber ( RATING_NUMBER )
                .rating       ( RATING )
                .stock        ( STOCK )
                .unitsSold    ( UNITS_SOLD )
                .upperLimit   ( UPPER_LIMIT )
                .lowerLimit   ( LOWER_LIMIT )
                .totalEarnings( TOTAL_EARNINGS )
                .onSale       ( ON_SALE )
                .onOffer      ( ON_OFFER )
                .isNew        ( IS_NEW )
                .discount     ( DISCOUNT )
                .comments     ( COMMENTS )
                .audit        ( this.audit )
                .build();

        assertThat( product.getId()            ).isEqualTo( this.id );
        assertThat( product.getCode()          ).isEqualTo( CODE );
        assertThat( product.getName()          ).isEqualTo( NAME );
        assertThat( product.getDescription()   ).isEqualTo( DESCRIPTION );
        assertThat( product.getBrand()         ).isEqualTo( BRAND );
        assertThat( product.getModel()         ).isEqualTo( MODEL );
        assertThat( product.getProductImages() ).isEqualTo( this.productImages );
        assertThat( product.getPrice()         ).isEqualTo( PRICE );
        assertThat( product.getRatingNumber()  ).isEqualTo( RATING_NUMBER );
        assertThat( product.getRating()        ).isEqualTo( RATING );
        assertThat( product.getStock()         ).isEqualTo( STOCK );
        assertThat( product.getUnitsSold()     ).isEqualTo( UNITS_SOLD );
        assertThat( product.getUpperLimit()    ).isEqualTo( UPPER_LIMIT );
        assertThat( product.getLowerLimit()    ).isEqualTo( LOWER_LIMIT );
        assertThat( product.getTotalEarnings() ).isEqualTo( TOTAL_EARNINGS );
        assertThat( product.getOnSale()        ).isEqualTo( ON_SALE );
        assertThat( product.getOnOffer()       ).isEqualTo( ON_OFFER );
        assertThat( product.getIsNew()         ).isEqualTo( IS_NEW );
        assertThat( product.getDiscount()      ).isEqualTo( DISCOUNT );
        assertThat( product.getComments()      ).isEqualTo( COMMENTS );
        assertThat( product.getAudit()         ).isEqualTo( this.audit );
    }

}
