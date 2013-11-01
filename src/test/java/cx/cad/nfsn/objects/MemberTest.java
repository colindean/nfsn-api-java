package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.net.APIRequest;
import cx.cad.nfsn.net.APIResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemberTest {

    Member member;
    API mockApi;

    @Before
    public void before(){
        mockApi = mock(API.class);
        when(mockApi.getMember("memberName")).thenReturn(new Member("memberName", mockApi));
        when(mockApi.createRequest()).thenReturn(new APIRequest(mockApi));
        member = mockApi.getMember("memberName");
    }

    @Test
    public void testGetEmail(){
        APIResponse response = new APIResponse("\"foo@bar.tld\"");
        when(mockApi.executeRequest(any(APIRequest.class))).thenReturn(response);
        assertEquals("foo@bar.tld", member.getEmail());
    }
    @Test
    public void testGetStatus(){
        APIResponse response = new APIResponse("\"active\"");
        when(mockApi.executeRequest(any(APIRequest.class))).thenReturn(response);
        assertEquals("active", member.getStatus());
    }
}
