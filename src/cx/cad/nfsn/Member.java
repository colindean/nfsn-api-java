package cx.cad.nfsn;

public class Member extends APIObject {

	private static final String type = "member";


  public Member(String username, API api){
	  super(username, api, type);
  }

  //properties
  
  public String getEmail(){

  }

  public String getPassword(){//this is probably not what it means

  }

  public String getStatus(){

  }

  public ArrayList<Account> getAccounts(){

  }

  public ArrayList<Site> getSites(){

  }

  //methods

  public void confirmNewEmail(String confirmationCode){

  }

  public String getAPIKey(String password){

  }

  public String getInfo(){

  }

  public void requestNewEmail(String email){

  }

  public String summarizeAccounts(){

  }

  public String summarizeDatabases(){

  }

  public String summarizeDomains(){

  }

  public String summarizeSites(){

  }
}
