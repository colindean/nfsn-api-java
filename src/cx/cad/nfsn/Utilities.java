package cx.cad.nfsn;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Utilities {

  private static final Logger LOGGER = Logger.getLogger(Utilities.class);

  public static String sha1Hash(String str){
    try {
      final MessageDigest hasher = new MessageDigest("SHA-1");
      final byte[] hashed = hash.digest(str.getBytes());
      return DatatypeConverter.printHexBinary(hashed).toLowerCase();
    } catch(NoSuchAlgorithmException e){
      LOGGER.error("SHA-1 digest unavailable", e);
      return null;
    }
  }

  /**
	 * Return a randomly-generated 16 character alphanumeric value 
   *   (a-z, A-Z, 0-9)
   *
	 * @return String salt
	 */
	public static String generateSalt(){
		String validChars = "abcdefghijlmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ0123456789";
		int length = 16;
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(length);
		while(sb.length() != length)
			sb.append(validChars.charAt(rand.nextInt(validChars.length())));
		return sb.toString();
	}
}
