package cx.cad.nfsn.integration;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import cx.cad.nfsn.API;
import cx.cad.nfsn.TestingProperties;
import cx.cad.nfsn.objects.Member;
import org.junit.Before;
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

    @Betamax(tape="integration.member.getEmail")
    @Test
    public void testGetEmail(){
        assertEquals(properties.getProperty("integration.member.email"), member.getEmail());
    }
}
