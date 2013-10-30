package cx.cad.nfsn;

import org.junit.Before;

public class APITest {

    private API api;

    @Before
    public void setUp() throws Exception {
        this.api = new API("user", "key", true);
    }

}
