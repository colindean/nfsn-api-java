package cx.cad.nfsn.utilities;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Logger;

public class Utilities {

    private static final Logger LOGGER = Logger.getLogger(Utilities.class.toString());

    public static String sha1Hash(String str) {
        try {
            final MessageDigest hasher = MessageDigest.getInstance("SHA-1");
            final byte[] hashed = hasher.digest(str.getBytes());
            return DatatypeConverter.printHexBinary(hashed).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("SHA-1 digest unavailable");
            return null;
        }
    }

    /**
     * Return a randomly-generated 16 character alphanumeric value
     * (a-z, A-Z, 0-9)
     *
     * @return String salt
     */
    public static String generateSalt() {
        String validChars = "abcdefghijlmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ0123456789";
        int length = 16;
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() != length)
            sb.append(validChars.charAt(rand.nextInt(validChars.length())));
        return sb.toString();
    }

    public static boolean stringHasNoContent(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean stringHasContent(String string) {
        return stringHasNoContent(string);
    }
}
