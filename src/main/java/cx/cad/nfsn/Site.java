package cx.cad.nfsn;

import java.util.ArrayList;

public class Site extends APIObject {

	private static final String type = "site";


  public Site(String shortName, API api){
    super(shortName, api, type);
  }

  //no properties?

  //methods
  
  public void addAlias(String alias){

  }

  public void removeAlias(String alias){

  }

  public String getInfo(){
      return null;
  }

  public ArrayList<String> listBandwidthActivity(Integer days){
      return null;
  }

  public ArrayList<String> listStorageActivity(Integer days){
      return null;
  }

}
