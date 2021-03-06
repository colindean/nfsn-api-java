package cx.cad.nfsn.integration;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import cx.cad.nfsn.TestingProperties;
import cx.cad.nfsn.objects.APIObject;
import cx.cad.nfsn.objects.Member;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MemberIntegrationTest {

    @Rule
    public Recorder recorder = new Recorder();

    Member member;

    TestingProperties properties;

    @Before
    public void before() throws IOException {
        properties = TestingProperties.loadTestingProperties();
        API api = new API(properties.getProperty("integration.login"), properties.getProperty("integration.key"), API.DEBUG_MODE);
        member = api.getMember(properties.getProperty("integration.member.username"));
    }

    @Ignore(value = "Awaiting NFSN implementation")
    @Betamax(tape = "cx.cad.nfsn.integration.member.getEmail")
    @Test
    public void testGetEmail() throws APIObject.NFSNNotYetImplementedException {
        assertEquals(properties.getProperty("integration.member.email"), member.getEmail());
    }

    @Ignore(value = "Awaiting NFSN implementation")
    @Betamax(tape = "cx.cad.nfsn.integration.member.getStatus")
    @Test
    public void testGetStatus() throws APIObject.NFSNNotYetImplementedException {
        assertEquals(properties.getProperty("integration.member.status"), member.getStatus());
    }

    @Betamax(tape="cx.cad.nfsn.integration.member.getSites")
    @Test
    public void testGetSites(){
        assertThat(member.getSites(), hasSize(Integer.parseInt(properties.getProperty("integration.member.numSites"))));
    }

    @Betamax(tape="cx.cad.nfsn.integration.member.getAccounts")
    @Test
    public void testGetAccounts(){
        assertThat(member.getAccounts(), hasSize(Integer.parseInt(properties.getProperty("integration.member.numAccounts"))));
    }
}
