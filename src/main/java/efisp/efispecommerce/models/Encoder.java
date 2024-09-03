package efisp.efispecommerce.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class to encode a string using SHA-256 algorithm
 */
public class Encoder {

    /**
     * Encode a string using SHA-256 algorithm
     * @param message the string to be encoded
     * @return the encoded string
     */
    public static String encode(String message) {
        String encrypted;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(message.getBytes(StandardCharsets.UTF_8));

            StringBuilder builder = new StringBuilder();

            for(byte b : bytes) {
                builder.append(String.format("%02x", b));
            }

            encrypted = builder.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting data", e);
        }

        return encrypted;
    }
}
