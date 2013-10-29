package cx.cad.nfsn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilitiesTest {

    String salt;

    @Before
    public void before() {
        salt = Utilities.generateSalt();
    }

    @Test
    public void testSaltLength() {
        assertEquals("Length must be 16", 16, salt.length());
    }

    @Test
    public void testSaltContainsValidChars() {
        assertTrue("Must contain only letters and numbers", salt.matches("[a-zA-Z0-9]*"));

    }
}
