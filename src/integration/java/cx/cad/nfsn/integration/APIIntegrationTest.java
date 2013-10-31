package cx.cad.nfsn.integration;

import cx.cad.nfsn.API;
import cx.cad.nfsn.objects.Account;
import cx.cad.nfsn.models.AccountStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class APIIntegrationTest {

    private API api;

    @Before
    public void setUp() throws Exception {
        String user = System.getenv("NSFN_USER");
        String key = System.getenv("NSFN_KEY");
        this.api = new API(user, key, true);
    }

    @Ignore("Not yet implemented")
    @Test
    public void testAccountStatus() {
        Account a = api.getAccount(System.getenv("NSFN_TEST_ACCOUNT"));
        AccountStatus status = a.getStatus();
        assertNotNull(status.getStatus());
        assertNotNull(status.getColor());
        assertNotNull(status.getShortCode());
    }
}
