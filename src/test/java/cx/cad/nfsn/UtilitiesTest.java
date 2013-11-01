package cx.cad.nfsn;

import cx.cad.nfsn.utilities.Utilities;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    @Test
    public void testStringHasNoContent(){
        assertTrue(Utilities.stringHasNoContent(""));
        assertTrue(Utilities.stringHasNoContent(null));
        assertFalse(Utilities.stringHasNoContent("foo"));
    }

    @Test
    public void testStringHasContent(){
        assertTrue(Utilities.stringHasContent("foo"));
        assertFalse(Utilities.stringHasContent(""));
        assertFalse(Utilities.stringHasContent(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRequireFailure(){
        Utilities.require("testing null", null);
    }
}
