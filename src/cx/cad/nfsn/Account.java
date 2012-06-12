package cx.cad.nsfn;

class Account {

  private String id;

  public Account(String id){
    this.id = id;
  }

  //properties

  public Integer getBalance(){
    
  }

  public Integer getBalanceCash(){

  }

  public Integer getBalanceCredit(){

  }

  public Integer getBalanceHigh(){

  }

  public String getFriendlyName(){
  
  }

  public void setFriendlyName(String name){
  //put
  }

  public AccountStatus getStatus(){
  //returns json with status, short, and color in hex
  }

  public ArrayList<Site> getSites(){

  }

  //methods

  public Site addSite(String shortName){

  }

  public void addWarning(Integer cents){
  //send the cents div 100 as a string
  }

  public String getInfo(){

  }

  public String listActivityCurrent(){

  }

  public String listActivityOld(){

  }

  public void removeWarning(Integer cents){

  }

}
