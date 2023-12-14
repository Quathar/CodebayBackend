package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <h1>Store Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class StoreTests {

    // <<-FIELD->>
    private Store mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Store.class);
    }

    // <<-TESTS->>
    @Test
    void fullArgsConstructorTest() {
        Store store = new Store(
                this.mock.getId(),
                this.mock.getAddress(),
                this.mock.getImage(),
                this.mock.getCoordinates()
        );

        assertThat( store.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( store.getAddress()     ).isEqualTo( this.mock.getAddress() );
        assertThat( store.getImage()       ).isEqualTo( this.mock.getImage() );
        assertThat( store.getCoordinates() ).isEqualTo( this.mock.getCoordinates() );
    }

    @Test
    void setterTest() {
        Store store = Store.builder().build();

        store.setId         ( this.mock.getId() );
        store.setAddress    ( this.mock.getAddress() );
        store.setImage      ( this.mock.getImage() );
        store.setCoordinates( this.mock.getCoordinates() );

        assertThat( store.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( store.getAddress()     ).isEqualTo( this.mock.getAddress() );
        assertThat( store.getImage()       ).isEqualTo( this.mock.getImage() );
        assertThat( store.getCoordinates() ).isEqualTo( this.mock.getCoordinates() );
    }

    @Test
    void builderTest() {
        Store store = Store.builder()
                .id         ( this.mock.getId() )
                .address    ( this.mock.getAddress() )
                .image      ( this.mock.getImage() )
                .coordinates( this.mock.getCoordinates() )
                .build();

        assertThat( store.getId()          ).isEqualTo( this.mock.getId() );
        assertThat( store.getAddress()     ).isEqualTo( this.mock.getAddress() );
        assertThat( store.getImage()       ).isEqualTo( this.mock.getImage() );
        assertThat( store.getCoordinates() ).isEqualTo( this.mock.getCoordinates() );
    }

}
