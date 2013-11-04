package cx.cad.nfsn.integration;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import cx.cad.nfsn.TestingProperties;
import cx.cad.nfsn.objects.Member;
import cx.cad.nfsn.objects.NFSNNotYetImplementedException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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

    @Ignore(value = "Awaiting key")
    @Betamax(tape = "cx.cad.nfsn.integration.member.getEmail")
    @Test
    public void testGetEmail() throws NFSNNotYetImplementedException {
        assertEquals(properties.getProperty("integration.member.email"), member.getEmail());
    }

    @Ignore(value = "Awaiting key")
    @Betamax(tape = "cx.cad.nfsn.integration.member.getStatus")
    @Test
    public void testGetStatus() throws NFSNNotYetImplementedException {
        assertEquals(properties.getProperty("integration.member.status"), member.getStatus());
    }
}
