package cx.cad.nfsn.integration;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import cx.cad.nfsn.TestingProperties;
import cx.cad.nfsn.objects.Account;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountIntegrationTest {

    @Rule
    public Recorder recorder = new Recorder();

    private Account account;
    private TestingProperties properties;

    @Before
    public void before() throws IOException {
        properties = TestingProperties.loadTestingProperties();
        API api = new API(properties.getProperty("integration.login"), properties.getProperty("integration.key"), API.DEBUG_MODE);
        account = api.getAccount(properties.getProperty("integration.account.id"));
    }

    @Ignore(value="Awaiting key")
    @Betamax(tape="integration.account.getBalance")
    @Test
    public void testRetrievesBalance() {
        assertThat(account.getBalance(), equalTo(1));
    }

}
