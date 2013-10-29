package cx.cad.nfsn.net;

import cx.cad.nfsn.API;
import cx.cad.nfsn.utilities.InformationNeededException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class APIRequestTest {

    private APIRequest req;
    private String login;
    private String apiKey;

    private static String PATH = "/foo";
    private static String BODY = "bar";
    // echo -n bar | shasum --algorithm 1 --text
    private static String BODY_SHASUM = "62cdb7020ff920e5aa642c3d4066950dd1f01f4d";

    @Before
    public void before() {
        login = System.getProperty("api.login", "nsfn-test-user");
        apiKey = System.getProperty("api.key", "nsfn-test-key");
        API api = new API(login, apiKey, API.DEBUG_MODE);
        req = api.createRequest();
        req.setPath(PATH);
        req.setBody(BODY);
    }

    @Test
    public void testCreation() {
        assertEquals("bar", req.getBody());
        assertEquals("/foo", req.getPath());
        assertEquals("GET", req.getMethod());
    }

    @Test
    public void testGetAuthHeaderPreamble() throws InformationNeededException {
        String salt = "salt";
        String expected = String.format("%s;%d;%s;", login, 1, salt);
        assertEquals(expected, req.getAuthHeaderPreamble(1000L, salt).toString());
    }

    @Test
    public void testGetAuthHeaderHash() throws InformationNeededException {
        String preamble = "preamble";
        String expected = String.format("%s;%s;%s;%s", preamble, apiKey, PATH, BODY_SHASUM);
        assertEquals(expected, req.getAuthHeaderHash(preamble));
    }

    @Test(expected = InformationNeededException.class)
    public void testUnsetPath() throws InformationNeededException {
        API api = new API(login, apiKey, API.DEBUG_MODE);
        req = api.createRequest();
        req.getAuthHeaderValue();
    }

    @Test(expected = InformationNeededException.class)
    public void testUnsetBody() throws InformationNeededException {
        API api = new API(login, apiKey, API.DEBUG_MODE);
        req = api.createRequest();
        req.setPath(PATH);
        req.getAuthHeaderValue();
    }
}