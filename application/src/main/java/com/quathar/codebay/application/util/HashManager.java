package com.quathar.codebay.application.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * <h1>Hash Manager</h1>
 * <br>
 * <p>
 *     Provides methods to hash passwords and verify hashed passwords.
 * </p>
 *
 * @since 2023-01-14
 * @version 2.0
 * @author juanagui, Q
 */
public abstract class HashManager {

    // <<-CONSTANTS->>
    /**
     * Size of the salt in bytes.
     */
    private static final int SALT_SIZE_BYTES = 16;
    /**
     * Size of the hash in bytes.
     */
    private static final int HASH_SIZE_BYTES = 32;
    /**
     * Hashing algorithm.
     */
    private static final String DEFAULT_ALGORITHM = "PBKDF2WithHmacSHA256";

    // <<-METHODS->>
    /**
     * Hashes the provided password using the specified algorithm and salt.
     *
     * @param algorithm The hashing algorithm to use
     * @param password  The password to be hashed
     * @param salt      The salt to perform the hash
     * @return The hashed password
     */
    private static byte[] encode(String algorithm, String password, byte[] salt) {
        byte[] generatedPassword;
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 310000, HASH_SIZE_BYTES * 8);
            generatedPassword = secretKeyFactory.generateSecret(keySpec).getEncoded();
        } catch (NoSuchAlgorithmException nsaE) {
            throw new InvalidAlgorithmException("The algorithm specification DOES NOT exist");
        } catch (InvalidKeySpecException iksE) {
            throw new RuntimeException("The key specification is NOT correct");
        }
        byte[] concatenated = new byte[SALT_SIZE_BYTES + HASH_SIZE_BYTES];
        System.arraycopy(salt, 0, concatenated, 0, SALT_SIZE_BYTES);
        System.arraycopy(generatedPassword, 0, concatenated, SALT_SIZE_BYTES, HASH_SIZE_BYTES);
        // The concatenated array follows this schema:
        // [salt + [hashed password + salt]]
        return concatenated;
    }

    /**
     * Hashes the provided password using the specified algorithm and a randomly generated salt.
     *
     * @param algorithm The hashing algorithm to use
     * @param password  The password to be hashed
     * @return The hashed password
     */
    public static String hash(String algorithm, String password) {
        if (password == null)
            throw new NullPointerException();
        byte[] salt = new byte[SALT_SIZE_BYTES];
        new SecureRandom().nextBytes(salt);
        byte[] encoded = encode(algorithm, password, salt);
        // Once the password is hashed we encode with Base64
        return Base64.getEncoder().encodeToString(encoded);
    }

    /**
     * Hashes the provided password using the default algorithm and a randomly generated salt.
     *
     * @param password The password to be hashed
     * @return The hashed password
     */
    public static String hash(String password) {
        return HashManager.hash(DEFAULT_ALGORITHM, password);
    }

    /**
     * Verifies if the raw password matches the hashed password using the specified algorithm.
     *
     * @param algorithm      The hashing algorithm used
     * @param rawPassword    The password to check
     * @param hashedPassword The hashed password
     * @return {@code true} if the passwords match, {@code false} otherwise
     */
    public static Boolean matches(String algorithm, String rawPassword, String hashedPassword) {
        byte[] concatenated = Base64.getDecoder().decode(hashedPassword);
        byte[] salt = new byte[SALT_SIZE_BYTES];
        System.arraycopy(concatenated, 0, salt, 0, SALT_SIZE_BYTES);
        byte[] encoded = encode(algorithm, rawPassword, salt);
        return MessageDigest.isEqual(concatenated, encoded);
    }

    /**
     * Verifies if the raw password matches the hashed password.
     *
     * @param rawPassword    The password to check
     * @param hashedPassword The hashed password
     * @return {@code true} if the passwords matches, {@code false} otherwise
     */
    public static Boolean matches(String rawPassword, String hashedPassword) {
        return HashManager.matches(DEFAULT_ALGORITHM, rawPassword, hashedPassword);
    }

    /**
     * This exception is thrown when an invalid algorithm is encountered.
     */
    static class InvalidAlgorithmException extends RuntimeException {

        public InvalidAlgorithmException(String message) {
            super(message);
        }

    }

}
