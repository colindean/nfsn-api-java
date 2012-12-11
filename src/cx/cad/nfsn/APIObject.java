package cx.cad.nfsn;

public class APIObject {
	
	private String identifier = null;
	private API api = null;
	private String type = null;
	
	public APIObject(String identifier, API api, String type){
		this.identifier = identifier;
		this.api = api;
		this.type = type;
	}
	
	public void setAPI(API api){
		this.api = api;
	}
	
	public API getAPI(){
		return this.api;
	}
	
	public void setIdentifier(String identifier){
		this.identifier = identifier;
	}
	
	public String getIdentifier(){
		return this.identifier;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	

}
