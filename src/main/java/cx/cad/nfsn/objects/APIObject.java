package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.net.APIRequest;
import cx.cad.nfsn.net.APIResponse;

public class APIObject {

    private String identifier = null;
    private API api = null;
    private String type = null;

    public APIObject(String identifier, API api, String type) {
        this.identifier = identifier;
        this.api = api;
        this.type = type;
    }

    public void setAPI(API api) {
        this.api = api;
    }

    public API getAPI() {
        return this.api;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getPath() {
        return getType() + "/" + getIdentifier();
    }

    /**
     * Passthrough to API.createRequest()
     *
     * @return APIRequest
     */
    public APIRequest createRequest() {
        return api.createRequest();
    }

    /**
     * Passthrough to API.executeRequest()
     *
     * @return APIResponse
     */
    public APIResponse executeRequest(APIRequest request) {
        return api.executeRequest(request);
    }

    /**
     * Handle a basic GET request to a path
     * <p/>
     * This is a convenience method, because most properties just do this.
     *
     * @param String the path
     * @return response object
     */
    public APIResponse executeGetFromPath(String path) {
        APIRequest req = createRequest();
        req.setMethod("GET"); // this is actually already default
        req.setPath(path);
        //there's nothing else to set here
        return executeRequest(req);
    }
}
