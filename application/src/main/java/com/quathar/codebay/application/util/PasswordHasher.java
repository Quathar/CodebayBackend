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
 * <h1>Password Hasher</h1>
 * <br>
 * <p>
 *     Provides methods to hash passwords and verify hashed passwords.
 * </p>
 *
 * @since 2023-01-14
 * @version 2.0
 * @author juanagui, Q
 */
public abstract class PasswordHasher {

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
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    // <<-METHODS->>
    /**
     * Hashes a password.
     * 
     * @param password The password to be hashed
     * @return The hashed password
     */
    public static String hash(String password) {
        byte[] salt = new byte[SALT_SIZE_BYTES];
        new SecureRandom().nextBytes(salt);
        byte[] encoded = encode(password, salt);
        // Once the password is hashed we encode with Base64
        return Base64.getEncoder().encodeToString(encoded);
    }

    /**
     * Encodes the password with the given salt.
     *
     * @param password The password to be hashed
     * @param salt     The salt to perform the hash
     * @return The hashed password
     */
    private static byte[] encode(String password, byte[] salt) {
        byte[] concatenated = new byte[SALT_SIZE_BYTES + HASH_SIZE_BYTES];
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 310000, HASH_SIZE_BYTES * 8);
            byte[] generatedPassword = secretKeyFactory.generateSecret(keySpec).getEncoded();
            System.arraycopy(salt, 0, concatenated, 0, SALT_SIZE_BYTES);
            System.arraycopy(generatedPassword, 0, concatenated, SALT_SIZE_BYTES, HASH_SIZE_BYTES);
        } catch (NoSuchAlgorithmException nsaE) {
            throw new RuntimeException("The algorithm specification DOES NOT exist");
        } catch (InvalidKeySpecException iksE) {
            throw new RuntimeException("The key specification is NOT correct");
        }
        // The concatenated array follows this schema:
        // [salt + [hashed password + salt]]
        return concatenated;
    }

    /**
     * Verifies if the raw password matches the hashed password.
     *
     * @param rawPassword    The password to check
     * @param hashedPassword The hashed password
     * @return {@code true} if the passwords matches, {@code false} otherwise
     */
    public static Boolean matches(String rawPassword, String hashedPassword) {
        byte[] concatenated = Base64.getDecoder().decode(hashedPassword);
        byte[] salt = new byte[SALT_SIZE_BYTES];
        System.arraycopy(concatenated, 0, salt, 0, SALT_SIZE_BYTES);
        byte[] encoded = encode(rawPassword, salt);
        return MessageDigest.isEqual(concatenated, encoded);
    }

}
