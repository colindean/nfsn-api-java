package cx.cad.nfsn;

public class APIRequest {

    private String path;
    private String body;
    private String method = "GET";
    private API api;

    public APIRequest(API api) {
        this.api = api;
    }

    /**
     * Set the path of the request
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the path of the request
     *
     * @return String the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Set the body of the request
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Get the body of the request
     *
     * @return String the body
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Set the method to be used
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Get the method to be used
     *
     * @return String the method
     */
    public String getMethod() {
        return this.method;
    }

    /**
     * Generate the authentication header value
     * <p/>
     * authentication = login;timestamp;salt;hash
     * login = <the nfsn username>
     * timestamp = <the current utc timestamp>
     * salt = <random salt>
     * hash = login;timestamp;salt;api-key;request-uri;body-hash
     * api-key = <the nfsn api-key>
     * request-uri = <the resource requested>
     * body-hash = sha1(<request body>)
     *
     * @return String
     */
    public String getAuthHeaderValue() {
        StringBuilder preamble = new StringBuilder();
        preamble.append(api.getLogin());
        preamble.append(";");
        preamble.append(System.currentTimeMillis() / 1000);
        preamble.append(";");
        preamble.append(Utilities.generateSalt());
        preamble.append(";");


        return preamble.append(getAuthHeaderHash(preamble.toString())).toString();
    }

    /**
     * Generate the header auth hash given a preamble
     *
     * @return String the hash
     */
    public String getAuthHeaderHash(String preamble) {
        StringBuilder output = new StringBuilder();
        output.append(preamble);
        output.append(";");
        output.append(api.getApiKey());
        output.append(";");
        output.append(getPath());
        output.append(";");
        output.append(getBodyAsHash());
        return output.toString();
    }

    /**
     * Hash the body
     *
     * @return String the sha1 hash of the body
     */
    private String getBodyAsHash() {
        return Utilities.sha1Hash(getBody());
    }


}
