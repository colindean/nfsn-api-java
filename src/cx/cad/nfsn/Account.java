package cx.cad.nfsn;

public class Account extends APIObject {

  private static final String type = "account";

  public Account(String id, API api){
    super(id, api, type);
  }

  //properties

  public Integer getBalance(){
    String path = "/balance";
    
  }

  public Integer getBalanceCash(){
    String path = "/balanceCash";

  }

  public Integer getBalanceCredit(){
    String path = "/balanceCredit";

  }

  public Integer getBalanceHigh(){
    String path = "/balanceHigh";

  }

  public String getFriendlyName(){
    String path = "/friendlyName";
  
  }

  public void setFriendlyName(String name){
    String path = "/friendlyName";
    //put
  }

  public AccountStatus getStatus(){
    //returns json with status, short, and color in hex
    String path = "/status";
    return AccountStatus.newFromMap(executeGetFromPath(path).fromJson());
  }

  public ArrayList<Site> getSites(){
    String path = "/sites";

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
