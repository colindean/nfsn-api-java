package cx.cad.nfsn;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class APITest {

    private API api;

    @Before
    public void setUp() throws Exception {
        this.api = new API("user", "key", true);
    }

    @Ignore("Not yet implemented")
    @Test
    public void testAPI() {
        assertTrue(this.api.getClass().equals(API.class));
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetAccount() {
        assertTrue(this.api.getAccount("account").getClass().equals(Account.class));
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetDatabase() {
        assertTrue(this.api.getDatabase("database").getClass().equals(Database.class));
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetDNS() {
        fail("Not yet implemented");

    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetEmail() {
        fail("Not yet implemented");
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetMember() {
        fail("Not yet implemented");
    }

    @Ignore("Not yet implemented")
    @Test
    public void testGetSite() {
        fail("Not yet implemented");
    }

}
