package cx.cad.nfsn.net;

import cx.cad.nfsn.API;
import cx.cad.nfsn.utilities.InformationNeededException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class APIRequestTest {

    private APIRequest request;
    private final String expectedValue = "testuser;1012121212;dkwo28Sile4jdXkw;0fa8932e122d56e2f6d1550f9aab39c4aef8bfc4";
    /*
     when debugging, expectedPreHash =
     "testuser;1012121212;dkwo28Sile4jdXkw;p3kxmRKf9dk3l6ls;/site/example/getInfo;da39a3ee5e6b4b0d3255bfef95601890afd80709"
     */
    private final String expectedPreamble = "testuser;1012121212;dkwo28Sile4jdXkw;";
    private final String expectedHash = "0fa8932e122d56e2f6d1550f9aab39c4aef8bfc4";

    private final String login = "testuser";
    private final long timestamp = 1012121212000L;
    private final String salt = "dkwo28Sile4jdXkw";
    private final String apiKey = "p3kxmRKf9dk3l6ls";
    private final String path = "/site/example/getInfo";
    private final String body = "";

    @Before
    public void before() {
        request = new APIRequest(getMockAPI());
        request.setPath(path);
        request.setBody(body);
    }

    private API getMockAPI() {
        API mockApi = mock(API.class);
        when(mockApi.getLogin()).thenReturn(login);
        when(mockApi.getApiKey()).thenReturn(apiKey);
        return mockApi;
    }

    @Test
    public void testCreation() {
        assertEquals(body, request.getBody());
        assertEquals(path, request.getPath());
        assertEquals("GET", request.getMethod());
    }

    @Test
    public void testAuthHeaderFromAPIReference() throws InformationNeededException {
        assertEquals(expectedValue, request.getAuthHeaderValue(timestamp, salt));
    }

    @Test
    public void testAuthHeaderHashFromAPIReference() throws InformationNeededException {
        assertEquals(expectedHash, request.getAuthHeaderHash(expectedPreamble));
    }

    @Test
    public void testGetAuthHeaderPreamble() throws InformationNeededException {
        String salt = "salt";
        String expected = String.format("%s;%d;%s;", login, 1, salt);
        assertEquals(expected, request.getAuthHeaderPreamble(1000L, salt).toString());
    }

    @Test(expected = InformationNeededException.class)
    public void testUnsetPath() throws InformationNeededException {
        request = new APIRequest(getMockAPI());
        request.getAuthHeaderValue();
    }

}