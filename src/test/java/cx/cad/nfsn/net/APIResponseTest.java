package cx.cad.nfsn.net;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APIResponseTest {

    private final String errorJsonResponse = "{\"error\": \"You messed up.\",\"debug\":\"You messed up real good.\"}";
    private final String desirableJsonResponse = "{\"balance\": 1000,\"status\":\"success\"}";

    APIResponse errorResponse, desirableResponse;

    @Before
    public void before(){
        errorResponse = new APIResponse(errorJsonResponse);
        desirableResponse = new APIResponse(desirableJsonResponse);
    }

    @Test
    public void testIsErrorResponse(){
        assertTrue(errorResponse.isError());
    }

    @Test
    public void testGetError(){
        assertEquals("You messed up.", errorResponse.getError());
    }

    @Test
    public void testGetDebug(){
        assertEquals("You messed up real good.", errorResponse.getDebugMessage());
    }

    @Test
    public void testGetValue(){
        assertEquals(1000L, desirableResponse.getJson().get("balance"));
    }
}
