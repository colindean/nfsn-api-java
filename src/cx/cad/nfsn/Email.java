package cx.cad.nfsn;

class Email {

  private String domain;

  public Email(String domain){
    this.domain = domain;
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
