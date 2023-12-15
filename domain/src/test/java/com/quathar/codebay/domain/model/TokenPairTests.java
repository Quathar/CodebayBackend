package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Token Pair Model Tests</h1>
 *
 * @since 2023-12-15
 * @version 1.0
 * @author Q
 */
class TokenPairTests {

    // <<-FIELD->>
    private TokenPair mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(TokenPair.class);
    }

    @Test
    void fullArgsConstructorTest() {
        TokenPair tokenPair = new TokenPair(
                this.mock.getType(),
                this.mock.getRefreshToken(),
                this.mock.getAccessToken()
        );

        assertThat( tokenPair.getType()         ).isEqualTo( this.mock.getType() );
        assertThat( tokenPair.getRefreshToken() ).isEqualTo( this.mock.getRefreshToken() );
        assertThat( tokenPair.getAccessToken()  ).isEqualTo( this.mock.getAccessToken() );
    }

    @Test
    void setterTest() {
        TokenPair tokenPair = TokenPair.builder().build();

        tokenPair.setType        ( this.mock.getType() );
        tokenPair.setRefreshToken( this.mock.getRefreshToken() );
        tokenPair.setAccessToken ( this.mock.getAccessToken() );

        assertThat( tokenPair.getType()         ).isEqualTo( this.mock.getType() );
        assertThat( tokenPair.getRefreshToken() ).isEqualTo( this.mock.getRefreshToken() );
        assertThat( tokenPair.getAccessToken()  ).isEqualTo( this.mock.getAccessToken() );
    }

    @Test
    void builderTest() {
        TokenPair tokenPair = TokenPair.builder()
                .type        ( this.mock.getType() )
                .refreshToken( this.mock.getRefreshToken() )
                .accessToken ( this.mock.getAccessToken() )
                .build();

        assertThat( tokenPair.getType()         ).isEqualTo( this.mock.getType() );
        assertThat( tokenPair.getRefreshToken() ).isEqualTo( this.mock.getRefreshToken() );
        assertThat( tokenPair.getAccessToken()  ).isEqualTo( this.mock.getAccessToken() );
    }

}
