package cx.cad.nfsn.integration;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import cx.cad.nfsn.TestingProperties;
import cx.cad.nfsn.models.AccountStatus;
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

    @Betamax(tape="cx.cad.nfsn.integration.account.getBalance")
    @Test
    public void testRetrievesBalance() {
        assertThat(account.getBalance(), equalTo(new Double(properties.getProperty("integration.account.balance"))));
    }

    @Betamax(tape="cx.cad.nfsn.integration.account.getBalanceCash")
    @Test
    public void testGetsBalanceCash(){
        assertThat(account.getBalance(), equalTo(new Double(properties.getProperty("integration.account.balanceCash"))));
    }

    @Betamax(tape="cx.cad.nfsn.integration.account.getBalanceCredit")
    @Test
    public void testGetBalanceCredit(){
        assertThat(account.getBalanceCredit(), equalTo(new Double(properties.getProperty("integration.account.balanceCredit"))));
    }

    @Betamax(tape="cx.cad.nfsn.integration.account.getBalanceHigh")
    @Test
    public void testGetBalanceHigh(){
        assertThat(account.getBalanceHigh(), equalTo(new Double(properties.getProperty("integration.account.balanceHigh"))));
    }

    @Betamax(tape="cx.cad.nfsn.integration.account.getFriendlyName")
    @Test
    public void testGetFriendlyName(){
        assertThat(account.getFriendlyName(), equalTo(properties.getProperty("integration.account.id")));
    }

    @Betamax(tape="cx.cad.nfsn.integration.account.getStatus")
    @Test
    public void testGetStatus(){
        AccountStatus accountStatus = account.getStatus();
        assertThat(accountStatus.getColor(), equalTo(properties.getProperty("integration.account.status.color")));
        assertThat(accountStatus.getShortCode(), equalTo(properties.getProperty("integration.account.status.short")));
        assertThat(accountStatus.getStatus(), equalTo(properties.getProperty("integration.account.status.description")));
    }
}
