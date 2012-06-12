package cx.cad.nfsn;

class DNS {

  private String domain;

  public DNS(String domain){
    this.domain = domain;
  }

  //properties

  public Integer getExpire(){

  }

  public void setExpire(Integer seconds){
  //put
  //must be between 86400 and 2678400
  //must be >= refresh and retry values
  }

  public Integer getMinTTL(){

  }

  public void setMinTTL(Integer seconds){
  //put
  //min 60, max 2678400
  }

  public Integer getRefresh(){

  }

  public void setRefresh(Integer seconds){
    //put
    //must be >= minTTL
    //must be <= expire
  }

  public Integer getRetry(){

  }

  public void setRetry(Integer seconds){
    //put
    //must be >= 60
    //must be <= expire
  }

  public Integer getSerial(){

  }
  
  //methods

  public void addRR(String name, String type, String data, Integer seconds){

  }

  public void addRR(String name, String type, String data){
    //type must be A, AAAA, CNAME, MX, NS, PTR, SRV, TXT
    return addRR(name, type, data, new Integer(60));
  }

  public ArrayList<ResourceRecord> listRRs(){
    //supply a HashMap with keys name, type, or data to filter by value
    //supply nothing to get all records for the domain
    //supply an empty value for name to get records that have no name value
    //  these aply to the base domain only

  }

  public void removeRR(String name, String type, String data){

  }

  public String getInfo(){

  }

  public void updateSerial(){

  }
}
