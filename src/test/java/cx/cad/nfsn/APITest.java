package cx.cad.nfsn;

import org.junit.Before;
import org.junit.Test;

public class APITest {

    private API api;

    @Before
    public void setUp() throws Exception {
        this.api = new API("user", "key", true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApiWithoutLogin(){
        API api = new API("", "testkey", true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testApiWithoutKey(){
        API api = new API("testlogin", "", true);
    }

}
