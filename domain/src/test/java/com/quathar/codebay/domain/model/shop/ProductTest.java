package com.quathar.codebay.domain.model.shop;

import com.quathar.codebay.domain.MockProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Product Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class ProductTest {

    // <<-FIELD->>
    private Product mock;

    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Product.class);
    }

    // <<-TESTS->>
    @Test
    void builderTest() {
        Product product = Product.builder()
                .id           ( this.mock.getId() )
                .code         ( this.mock.getCode() )
                .name         ( this.mock.getName() )
                .description  ( this.mock.getDescription() )
                .brand        ( this.mock.getBrand() )
                .model        ( this.mock.getModel() )
                .productImages( this.mock.getProductImages() )
                .price        ( this.mock.getPrice() )
                .ratingNumber ( this.mock.getRatingNumber() )
                .rating       ( this.mock.getRating() )
                .stock        ( this.mock.getStock() )
                .unitsSold    ( this.mock.getUnitsSold() )
                .upperLimit   ( this.mock.getUpperLimit() )
                .lowerLimit   ( this.mock.getLowerLimit() )
                .totalEarnings( this.mock.getTotalEarnings() )
                .onSale       ( this.mock.getOnSale() )
                .onOffer      ( this.mock.getOnOffer() )
                .isNew        ( this.mock.getIsNew() )
                .discount     ( this.mock.getDiscount() )
                .comments     ( this.mock.getComments() )
                .audit        ( this.mock.getAudit() )
                .build();

        assertThat( product.getId()            ).isEqualTo( this.mock.getId()            );
        assertThat( product.getCode()          ).isEqualTo( this.mock.getCode()          );
        assertThat( product.getName()          ).isEqualTo( this.mock.getName()          );
        assertThat( product.getDescription()   ).isEqualTo( this.mock.getDescription()   );
        assertThat( product.getBrand()         ).isEqualTo( this.mock.getBrand()         );
        assertThat( product.getModel()         ).isEqualTo( this.mock.getModel()         );
        assertThat( product.getProductImages() ).isEqualTo( this.mock.getProductImages() );
        assertThat( product.getPrice()         ).isEqualTo( this.mock.getPrice()         );
        assertThat( product.getRatingNumber()  ).isEqualTo( this.mock.getRatingNumber()  );
        assertThat( product.getRating()        ).isEqualTo( this.mock.getRating()        );
        assertThat( product.getStock()         ).isEqualTo( this.mock.getStock()         );
        assertThat( product.getUnitsSold()     ).isEqualTo( this.mock.getUnitsSold()     );
        assertThat( product.getUpperLimit()    ).isEqualTo( this.mock.getUpperLimit()    );
        assertThat( product.getLowerLimit()    ).isEqualTo( this.mock.getLowerLimit()    );
        assertThat( product.getTotalEarnings() ).isEqualTo( this.mock.getTotalEarnings() );
        assertThat( product.getOnSale()        ).isEqualTo( this.mock.getOnSale()        );
        assertThat( product.getOnOffer()       ).isEqualTo( this.mock.getOnOffer()       );
        assertThat( product.getIsNew()         ).isEqualTo( this.mock.getIsNew()         );
        assertThat( product.getDiscount()      ).isEqualTo( this.mock.getDiscount()      );
        assertThat( product.getComments()      ).isEqualTo( this.mock.getComments()      );
        assertThat( product.getAudit()         ).isEqualTo( this.mock.getAudit()         );
    }

    @Test
    void settersTest() {
        Product product = Product.builder().build();

        product.setId           ( this.mock.getId()            );
        product.setCode         ( this.mock.getCode()          );
        product.setName         ( this.mock.getName()          );
        product.setDescription  ( this.mock.getDescription()   );
        product.setBrand        ( this.mock.getBrand()         );
        product.setModel        ( this.mock.getModel()         );
        product.setProductImages( this.mock.getProductImages() );
        product.setPrice        ( this.mock.getPrice()         );
        product.setRatingNumber ( this.mock.getRatingNumber()  );
        product.setRating       ( this.mock.getRating()        );
        product.setStock        ( this.mock.getStock()         );
        product.setUnitsSold    ( this.mock.getUnitsSold()     );
        product.setUpperLimit   ( this.mock.getUpperLimit()    );
        product.setLowerLimit   ( this.mock.getLowerLimit()    );
        product.setTotalEarnings( this.mock.getTotalEarnings() );
        product.setOnSale       ( this.mock.getOnSale()        );
        product.setOnOffer      ( this.mock.getOnOffer()       );
        product.setIsNew        ( this.mock.getIsNew()         );
        product.setDiscount     ( this.mock.getDiscount()      );
        product.setComments     ( this.mock.getComments()      );
        product.setAudit        ( this.mock.getAudit()         );

        assertThat( product.getId()            ).isEqualTo( this.mock.getId()            );
        assertThat( product.getCode()          ).isEqualTo( this.mock.getCode()          );
        assertThat( product.getName()          ).isEqualTo( this.mock.getName()          );
        assertThat( product.getDescription()   ).isEqualTo( this.mock.getDescription()   );
        assertThat( product.getBrand()         ).isEqualTo( this.mock.getBrand()         );
        assertThat( product.getModel()         ).isEqualTo( this.mock.getModel()         );
        assertThat( product.getProductImages() ).isEqualTo( this.mock.getProductImages() );
        assertThat( product.getPrice()         ).isEqualTo( this.mock.getPrice()         );
        assertThat( product.getRatingNumber()  ).isEqualTo( this.mock.getRatingNumber()  );
        assertThat( product.getRating()        ).isEqualTo( this.mock.getRating()        );
        assertThat( product.getStock()         ).isEqualTo( this.mock.getStock()         );
        assertThat( product.getUnitsSold()     ).isEqualTo( this.mock.getUnitsSold()     );
        assertThat( product.getUpperLimit()    ).isEqualTo( this.mock.getUpperLimit()    );
        assertThat( product.getLowerLimit()    ).isEqualTo( this.mock.getLowerLimit()    );
        assertThat( product.getTotalEarnings() ).isEqualTo( this.mock.getTotalEarnings() );
        assertThat( product.getOnSale()        ).isEqualTo( this.mock.getOnSale()        );
        assertThat( product.getOnOffer()       ).isEqualTo( this.mock.getOnOffer()       );
        assertThat( product.getIsNew()         ).isEqualTo( this.mock.getIsNew()         );
        assertThat( product.getDiscount()      ).isEqualTo( this.mock.getDiscount()      );
        assertThat( product.getComments()      ).isEqualTo( this.mock.getComments()      );
        assertThat( product.getAudit()         ).isEqualTo( this.mock.getAudit()         );
    }

}
