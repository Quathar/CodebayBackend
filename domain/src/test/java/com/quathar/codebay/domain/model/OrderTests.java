package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Order Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class OrderTests {

    // <<-FIELD->>
    private Order mock;

    // <<-TEST->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Order.class);
    }

    @Test
    void fullArgsConstructorTest() {
//        Order.Detail detail = new Order.Detail(
//                this.detailMock.getProduct(),
//                this.detailMock.getUnits(),
//                this.detailMock.getPrice()
//        );
//
//        assertThat( detail.getProduct() ).isEqualTo( this.detailMock.getProduct() );
//        assertThat( detail.getUnits()   ).isEqualTo( this.detailMock.getUnits() );
//        assertThat( detail.getPrice()   ).isEqualTo( this.detailMock.getPrice() );
//
//        Set<Order.Detail> details = Set.of(detail);
//
//        Order category = new Order(
//                this.mock.getId(),
//                this.mock.getCustomer(),
//                this.mock.getDate(),
//                details,
//                this.mock.getTotalPrice(),
//                this.mock.getStatus()
//        );
//
//        assertThat( category.getId()         ).isEqualTo( this.mock.getId() );
//        assertThat( category.getCustomer()   ).isEqualTo( this.mock.getCustomer() );
//        assertThat( category.getDate()       ).isEqualTo( this.mock.getDate() );
//        assertThat( category.getDetails()    ).isEqualTo( details );
//        assertThat( category.getTotalPrice() ).isEqualTo( this.mock.getTotalPrice() );
//        assertThat( category.getStatus()     ).isEqualTo( this.mock.getStatus() );
    }

    @Test
    void setterTest() {
//        Order.Detail detail = Order.Detail.builder().build();
//
//        detail.setProduct( this.detailMock.getProduct() );
//        detail.setUnits  ( this.detailMock.getUnits() );
//        detail.setPrice  ( this.detailMock.getPrice() );
//
//        assertThat( detail.getProduct() ).isEqualTo( this.detailMock.getProduct() );
//        assertThat( detail.getUnits()   ).isEqualTo( this.detailMock.getUnits() );
//        assertThat( detail.getPrice()   ).isEqualTo( this.detailMock.getPrice() );
//
//        Set<Order.Detail> details = Set.of(detail);
//
//        Order category = Order.builder().build();
//
//        category.setId        ( this.mock.getId() );
//        category.setCustomer  ( this.mock.getCustomer() );
//        category.setDate      ( this.mock.getDate() );
//        category.setDetails   ( details );
//        category.setTotalPrice( this.mock.getTotalPrice() );
//        category.setStatus    ( this.mock.getStatus() );
//
//        assertThat( category.getId()         ).isEqualTo( this.mock.getId() );
//        assertThat( category.getCustomer()   ).isEqualTo( this.mock.getCustomer() );
//        assertThat( category.getDate()       ).isEqualTo( this.mock.getDate() );
//        assertThat( category.getDetails()    ).isEqualTo( details );
//        assertThat( category.getTotalPrice() ).isEqualTo( this.mock.getTotalPrice() );
//        assertThat( category.getStatus()     ).isEqualTo( this.mock.getStatus() );
    }

    @Test
    void builderTest() {
//        Order.Detail detail = Order.Detail.builder()
//                .product( this.detailMock.getProduct() )
//                .units  ( this.detailMock.getUnits() )
//                .price  ( this.detailMock.getPrice() )
//                .build();
//
//        assertThat( detail.getProduct() ).isEqualTo( this.detailMock.getProduct() );
//        assertThat( detail.getUnits()   ).isEqualTo( this.detailMock.getUnits() );
//        assertThat( detail.getPrice()   ).isEqualTo( this.detailMock.getPrice() );
//
//        Set<Order.Detail> details = Set.of(detail);
//
//        Order category = Order.builder()
//                .id        ( this.mock.getId() )
//                .customer  ( this.mock.getCustomer() )
//                .date      ( this.mock.getDate() )
//                .details   ( details )
//                .totalPrice( this.mock.getTotalPrice() )
//                .status    ( this.mock.getStatus() )
//                .build();
//
//        assertThat( category.getId()         ).isEqualTo( this.mock.getId() );
//        assertThat( category.getCustomer()   ).isEqualTo( this.mock.getCustomer() );
//        assertThat( category.getDate()       ).isEqualTo( this.mock.getDate() );
//        assertThat( category.getDetails()    ).isEqualTo( details );
//        assertThat( category.getTotalPrice() ).isEqualTo( this.mock.getTotalPrice() );
//        assertThat( category.getStatus()     ).isEqualTo( this.mock.getStatus() );
    }

}
