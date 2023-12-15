package com.quathar.codebay.application.util;

import com.quathar.codebay.domain.model.TokenPair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * <h1>Token Pair Model Tests</h1>
 *
 * @since 2023-12-15
 * @version 1.0
 * @author Q
 */
class TokenManagerTests {

    // <<-TESTS->>
    @BeforeAll
    static void setup() {
        TokenManager.FILE = Path.of(System.getProperty("user.dir"),
                "src", "main", "resources",
                "token.properties");
    }

    @Test
    void givenDifferentSubjects_whenGeneratingTokenPairs_thenDifferentTokenPairsGenerated() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        TokenPair tokenPair1 = TokenManager.generateTokenPair(uuid1.toString());
        TokenPair tokenPair2 = TokenManager.generateTokenPair(uuid2.toString());

        assertThat( tokenPair1.getType()         ).isEqualTo( tokenPair2.getType() );
        assertThat( tokenPair1.getRefreshToken() ).isNotEqualTo( tokenPair2.getRefreshToken() );
        assertThat( tokenPair1.getAccessToken()  ).isNotEqualTo( tokenPair2.getAccessToken() );
    }

    @Test
    void givenTheSameSubject_whenGeneratingTokenPairsTwice_thenDifferentTokenPairsGenerated() {
        UUID uuid = UUID.randomUUID();
        TokenPair tokenPair1 = TokenManager.generateTokenPair(uuid.toString());
        TokenPair tokenPair2 = TokenManager.generateTokenPair(uuid.toString());

        assertThat( tokenPair1.getType()         ).isEqualTo( tokenPair2.getType() );
        assertThat( tokenPair1.getRefreshToken() ).isNotEqualTo( tokenPair2.getRefreshToken() );
        assertThat( tokenPair1.getAccessToken()  ).isNotEqualTo( tokenPair2.getAccessToken() );
    }

    @Test
    void givenSubjectAndClaims_whenGeneratingTokenPair_thenValidTokensGenerated() {
        UUID uuid = UUID.randomUUID();
        Map<String, Object> claims = new java.util.HashMap<>();
        claims.put("key1", "value1");
        claims.put("key2", 123);

        TokenPair tokenPair = TokenManager.generateTokenPair(uuid.toString(), claims);

        assertThat( tokenPair.getType()         ).isEqualTo("Bearer");
        assertThat( tokenPair.getRefreshToken() ).isNotBlank();
        assertThat( tokenPair.getAccessToken() ).isNotBlank();
    }

    @Test
    void givenInvalidSubject_whenGeneratingTokenPair_thenThrowsResourceNotFoundException() {
        assertThatThrownBy( () -> TokenManager.generateTokenPair(null) )
                .isInstanceOf( RuntimeException.class ); // Adjust to the specific exception you are expecting
    }

    @Test
    void givenInvalidToken_whenVerifying_thenReturnsFalse() {
        assertThat( TokenManager.verify("this.invalid.token") ).isFalse();
    }

    @Test
    void givenValidToken_whenVerifying_thenReturnsTrue() {
        UUID uuid = UUID.randomUUID();
        TokenPair tokenPair = TokenManager.generateTokenPair(uuid.toString());

        assertThat( TokenManager.verify(tokenPair.getAccessToken()) ).isTrue();
    }

}
