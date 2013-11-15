package cx.cad.nfsn.net;

import cx.cad.nfsn.API;
import cx.cad.nfsn.utilities.InformationNeededException;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APIExecutorTest extends Mockito {

    public final String jsonResponse = "{\"foo\": \"bar\"}";
    public final String jsonErrorResponse = "{\"error\": \"test error!\"}";


    @Test
    public void testBuildUrl() throws MalformedURLException {
        String path = "/path";
        String expected = API.PROTOCOL + "://" + API.DOMAIN + path;
        assertEquals(new URL(expected), APIExecutor.buildRequestUrl(path));
    }

    @Test
    public void testExceptionAsJson() {
        TestException e = new TestException("blah");
        assertEquals("{\"error\": \"cx.cad.nfsn.net.APIExecutorTest$TestException: blah\"}", APIExecutor.exceptionAsJson(e));

    }

    @Test
    public void testConnectionForPath() throws MalformedURLException {
        assertEquals("/path", APIExecutor.getConnectionForPath("/path").getURL().getPath());
    }

    @Test
    public void testSuccessExecution() throws InformationNeededException, IOException, ParseException {

        APIRequest request = mock(APIRequest.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getPath()).thenReturn("/path");
        when(request.getAuthHeaderValue()).thenReturn("authheadervalue");

        HttpURLConnection con = mock(HttpURLConnection.class);
        when(con.getInputStream()).thenReturn(IOUtils.toInputStream(jsonResponse));
        when(con.getResponseCode()).thenReturn(200);

        when(con.getErrorStream()).thenReturn(IOUtils.toInputStream(jsonErrorResponse));


        APIResponse response = APIExecutor.executeRequest(request, con);

        assertEquals(APIResponse.SUCCESS, response.getStatus());
        assertTrue(((JSONObject)response.getObject()).containsKey("foo"));

    }

    @Test
    public void testClientErrorExecution() throws InformationNeededException, IOException, ParseException {

        APIRequest request = mock(APIRequest.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getPath()).thenReturn("/path");
        when(request.getAuthHeaderValue()).thenReturn("authheadervalue");

        HttpURLConnection con = mock(HttpURLConnection.class);
        when(con.getInputStream()).thenReturn(IOUtils.toInputStream(jsonResponse));
        when(con.getResponseCode()).thenReturn(400);

        when(con.getErrorStream()).thenReturn(IOUtils.toInputStream(jsonErrorResponse));


        APIResponse response = APIExecutor.executeRequest(request, con);

        assertEquals(APIResponse.FAILURE, response.getStatus());
        assertTrue(((JSONObject)response.getObject()).containsKey("error"));

    }

    class TestException extends Exception {
        public TestException(String text){
            super(text);
        }
    }
}
