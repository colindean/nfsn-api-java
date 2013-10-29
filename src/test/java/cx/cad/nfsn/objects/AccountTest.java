package cx.cad.nfsn.objects;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountTest {

    @Rule
    public Recorder recorder = new Recorder();

    private API api;
    private Account account;

    @Before
    public void before(){
        String login = System.getProperty("api.login","nsfn-test-user");
        String apiKey = System.getProperty("api.key","nsfn-test-key");
        api = new API(login, apiKey, API.DEBUG_MODE);

    }

    @Ignore("Not yet implemented")
    @Betamax(tape="account.balance")
    @Test
    public void testRetrievesBalance() {
        assertThat(account.getBalance(), equalTo(3));
    }

}
