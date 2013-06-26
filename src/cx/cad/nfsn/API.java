package cx.cad.nfsn;

import java.util.Random;
import java.net.HttpURLConnection;
import com.squareup.okhttp.OkHttpClient;

public class API {

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
   * @param APIRequest the request object prepared in an APIObject method
   * @return the response object that the APIObject method can handle
   */
	public APIResponse executeRequest(APIRequest request){
    //do the http work and create a response object
    OkHttpClient client = new OkHttpClient();
    StringBuilder url = new StringBuilder();
    url.append(PROTOCOL).append("://").append(HOSTNAME);
    url.append(request.getPath());

    HttpURLConnection con = client.open(url.toString());
    con.setRequestMethod(request.getMethod());

    InputStream in = null;
    try {
      // Read the response.
      in = connection.getInputStream();
      byte[] response = readFully(in);
      return new APIResponse(new String(response, "UTF-8"));
    } finally {
      if (in != null) in.close();
    }
		return null;
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
}
