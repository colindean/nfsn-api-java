package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.net.APIRequest;
import cx.cad.nfsn.net.APIResponse;
import org.junit.Before;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class APIObjectTestParent {

    API mockApi;

    @Before
    public void setupMock(){
        mockApi = mock(API.class);
        when(mockApi.createRequest()).thenReturn(new APIRequest(mockApi));
    }

    protected void apiResponseIs(String jsonString) {
        APIResponse response = new APIResponse(jsonString);
        when(mockApi.executeRequest(any(APIRequest.class))).thenReturn(response);
    }

    protected APIObjectTestParent WHEN = this;

}
