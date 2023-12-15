package com.quathar.codebay.application.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * <h1>Hash Manager Tests</h1>
 *
 * @since 2023-11-18
 * @version 1.0
 * @author Q
 */
class HashManagerTests {

    // <<-CONSTANT->>
    private static final String PASSWORD = "password";

    // <<-TESTS->>
    @Test
    void givenPassword_whenHashedTwice_thenDifferentHashesGenerated() {
        String hashedPassword1 = HashManager.hash(PASSWORD);
        String hashedPassword2 = HashManager.hash(PASSWORD);

        assertThat( hashedPassword1 ).isNotEqualTo( hashedPassword2 );
    }

    @Test
    void givenPasswordHashedMultipleTimes_whenVerify_thenMatchingPasswords() {
        String hashedPassword1 = HashManager.hash(PASSWORD);
        String hashedPassword2 = HashManager.hash(PASSWORD);

        assertThat( HashManager.matches(PASSWORD, hashedPassword1) ).isTrue();
        assertThat( HashManager.matches(PASSWORD, hashedPassword2) ).isTrue();
    }

    @Test
    void givenNoPassword_whenHashing_thenThrowsNullPointerException() {
        assertThatThrownBy( () -> HashManager.hash(null) ).isInstanceOf( NullPointerException.class );
    }

    @Test
    void givenNoAlgorithmAndNoPassword_whenHashing_thenThrowsNullPointerException() {
        assertThatThrownBy( () -> HashManager.hash(null, null) ).isInstanceOf( NullPointerException.class );
    }

    @Test
    void givenNoAlgorithmAndCorrectPassword_whenHashing_thenThrowsNullPointerException() {
        assertThatThrownBy( () -> HashManager.hash(null, PASSWORD) ).isInstanceOf( NullPointerException.class );
    }

    @Test
    void givenWrongAlgorithmAndCorrectPassword_whenHashing_thenThrowsInvalidAlgorithmException() {
        assertThatThrownBy( () -> HashManager.hash("TheBestAlgorithm", PASSWORD) ).isInstanceOf( HashManager.InvalidAlgorithmException.class );
    }

    @RepeatedTest(3)
    void givenPassword_whenHashedTwice_thenResultIsNotEqualToOriginal() {
        String firstTime  = HashManager.hash(PASSWORD);
        String secondTime = HashManager.hash(firstTime);

        assertThat( secondTime ).isNotEqualTo( PASSWORD );
    }

}
