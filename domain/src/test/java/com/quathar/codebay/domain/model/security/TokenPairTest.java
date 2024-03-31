package com.quathar.codebay.domain.model.security;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Token Pair Model Tests</h1>
 *
 * @since 2024-03-31
 * @version 1.0
 * @author Q
 */
public class TokenPairTest {

    // <<-FIELD->>
    private TokenPair mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(TokenPair.class);
    }

    @Test
    void builderTest() {
        TokenPair tokenPair = TokenPair.builder()
                .accessToken ( this.mock.getAccessToken()  )
                .refreshToken( this.mock.getRefreshToken() )
                .build();

        assertThat( tokenPair.getAccessToken()  ).isEqualTo( this.mock.getAccessToken()  );
        assertThat( tokenPair.getRefreshToken() ).isEqualTo( this.mock.getRefreshToken() );
    }

    @Test
    void settersTest() {
        TokenPair tokenPair = TokenPair.builder().build();

        tokenPair.setAccessToken ( this.mock.getAccessToken()  );
        tokenPair.setRefreshToken( this.mock.getRefreshToken() );

        assertThat( tokenPair.getAccessToken()  ).isEqualTo( this.mock.getAccessToken()  );
        assertThat( tokenPair.getRefreshToken() ).isEqualTo( this.mock.getRefreshToken() );
    }

}
