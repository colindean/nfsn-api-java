package cx.cad.nfsn;

public class AccountStatus {

  private String status;
  private String short;
  private String color;

  private AccountStatus(){

  }

  public static AccountStatus newFromMap(Map map){
    AccountStatus as = new AccountStatus();

    as.setStatus(map.get("status"));
    as.setShort(map.get("short"));
    as.setColor(map.get("color"));
    
    return as;
  }

}
