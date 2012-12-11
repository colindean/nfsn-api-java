package cx.cad.nfsn;

import java.util.Random;

public class API {

	public static final String protocol = "https";
	public static final String domain = "api.nearlyfreespeech.net";
	
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
	
	public APIResponse makeRequest(APIObject object){
		return null;
	}
	
	/**
	 * Return a randomly-generated 16 character alphanumeric value (a-z, A-Z, 0-9)
	 * @return String salt
	 */
	public String generateSalt(){
		String validChars = "abcdefghijlmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ0123456789";
		int length = 16;
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(length);
		while(sb.length() != length)
			sb.append(validChars.charAt(rand.nextInt(validChars.length())));
		return sb.toString();
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
