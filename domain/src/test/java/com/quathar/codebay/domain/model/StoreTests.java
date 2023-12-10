package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.ModelProvider;
import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Coordinates;
import com.quathar.codebay.domain.model.common.Image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <h1>Store Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class StoreTests {

    // <<-FIELDS->>
    private UUID id;
    private Address address;
    private Image image;
    private Coordinates coordinates;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.id          = UUID.randomUUID();
        this.address     = ModelProvider.getInstance(Address.class);
        this.image       = ModelProvider.getInstance(Image.class);
        this.coordinates = ModelProvider.getInstance(Coordinates.class);
    }

    // <<-TESTS->>
    @Test
    void fullArgsConstructorTest() {
        Store store = new Store(
                this.id,
                this.address,
                this.image,
                this.coordinates
        );

        assertThat( store.getId()          ).isEqualTo(  this.id );
        assertThat( store.getAddress()     ).isEqualTo(  this.address );
        assertThat( store.getImage()       ).isEqualTo(  this.image );
        assertThat( store.getCoordinates() ).isEqualTo(  this.coordinates );
    }

    @Test
    void setterTest() {
        Store store = Store.builder().build();

        store.setId         ( this.id );
        store.setAddress    ( this.address );
        store.setImage      ( this.image );
        store.setCoordinates( this.coordinates );

        assertThat( store.getId()          ).isEqualTo(  this.id );
        assertThat( store.getAddress()     ).isEqualTo(  this.address );
        assertThat( store.getImage()       ).isEqualTo(  this.image );
        assertThat( store.getCoordinates() ).isEqualTo(  this.coordinates );
    }

    @Test
    void builderTest() {
        Store store = Store.builder()
                .id         ( this.id )
                .address    ( this.address )
                .image      ( this.image )
                .coordinates( this.coordinates )
                .build();

        assertThat( store.getId()          ).isEqualTo(  this.id );
        assertThat( store.getAddress()     ).isEqualTo(  this.address );
        assertThat( store.getImage()       ).isEqualTo(  this.image );
        assertThat( store.getCoordinates() ).isEqualTo(  this.coordinates );
    }

}
