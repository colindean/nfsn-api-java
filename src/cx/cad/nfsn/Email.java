package cx.cad.nfsn;

public class Email extends APIObject {

	private static final String type = "email";


  public Email(String domain, API api){
	  super(domain, api, type);
  }

  //methods

  public String getInfo(){

  }

  public HashMap<String,String> listForwards(){

  }

  public void removeForward(String user){

  }

  public void setForward(String fromUser, String toAddress){

  }

  //convenience methods?

  public void setBounce(String user){
    setForward(user, "bounce@nearlyfreespeech.net");
  }

  public void setDiscard(String user){
    setForward(user, "discard@nearlyfreespeech.net");
  }



  //no properties!
