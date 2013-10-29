package cx.cad.nfsn;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

import com.squareup.okhttp.OkHttpClient;
import org.apache.commons.io.IOUtils;

public class API {

    private static final Logger LOGGER = Logger.getLogger(API.class.toString());

	public static final String PROTOCOL = "https";
	public static final String DOMAIN = "api.nearlyfreespeech.net";
	
	private String login;
	private String apiKey;
	private boolean debug;
	
	public API(String login, String apiKey, boolean debug){
		this.setLogin(login);
		this.setApiKey(apiKey);
		this.setDebug(debug);
	}

    public API(String login, String apiKey){
        this(login, apiKey, false);
    }
	
	public Account getAccount(String id){
		return new Account(id, this);
	}
	
	public Database getDatabase(String id){
		return new Database(id, this);
	}
	
	public DNS getDNS(String domain){
		return new DNS(domain, this);
	}
	
	public Email getEmail(String domain){
		return new Email(domain, this);
	}
	
	public Member getMember(String username){
		return new Member(username, this);
	}
	
	public Site getSite(String shortName){
		return new Site(shortName, this);
	}

  public APIRequest createRequest(){
    return new APIRequest(this);
  }
	
  /**
   * Execute a request and return a response.
   *
   * Each APIObject method that uses this method is expected to know
   * what to do with the response.
   *
   * @param request the request object prepared in an APIObject method
   * @return the response object that the APIObject method can handle
   */
	public APIResponse executeRequest(APIRequest request) {
    //do the http work and create a response object
        OkHttpClient client = new OkHttpClient();
        StringBuilder url = new StringBuilder();
        url.append(PROTOCOL).append("://").append(DOMAIN);
        url.append(request.getPath());

        HttpURLConnection con = null;
        InputStream in = null;
        try {
            con = client.open(new URL(url.toString()));
            con.setRequestMethod(request.getMethod());
            // Read the response.
            in = con.getInputStream();
            String jsonResponse = IOUtils.toString(in, "UTF-8");
            return new APIResponse(jsonResponse);
        } catch (Exception e) {
            return new APIResponse(exceptionAsJson(e), APIResponse.FAILURE);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                LOGGER.warning("Encountered " + e + " while closing the request input stream.");
            }
        }
	}

    private String exceptionAsJson(Exception e) {
        return "{error: \"" + e.toString() + "\"}";
    }

    /**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

    public class RequestExecutionFailureException extends Throwable {
        public RequestExecutionFailureException(Exception e) {
            super(e);
        }
    }
}
