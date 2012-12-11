package cx.cad.nfsn;

public class Account extends APIObject {

  private static final String type = "account";

  public Account(String id, API api){
    super(id, api, type);
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
