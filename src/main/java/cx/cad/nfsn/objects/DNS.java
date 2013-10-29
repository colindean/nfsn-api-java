package cx.cad.nfsn.objects;

import com.sun.jndi.dns.ResourceRecord;
import cx.cad.nfsn.API;

import java.util.ArrayList;

public class DNS extends APIObject {

    private static final String type = "dns";


    public DNS(String domain, API api) {
        super(domain, api, type);
    }

    //properties

    public Integer getExpire() {
        return null;
    }

    public void setExpire(Integer seconds) {
        //put
        //must be between 86400 and 2678400
        //must be >= refresh and retry values
    }

    public Integer getMinTTL() {
        return null;
    }

    public void setMinTTL(Integer seconds) {
        //put
        //min 60, max 2678400
    }

    public Integer getRefresh() {
        return null;
    }

    public void setRefresh(Integer seconds) {
        //put
        //must be >= minTTL
        //must be <= expire
    }

    public Integer getRetry() {
        return null;
    }

    public void setRetry(Integer seconds) {
        //put
        //must be >= 60
        //must be <= expire
    }

    public Integer getSerial() {
        return null;
    }

    //methods

    public void addRR(String name, String type, String data, Integer seconds) {

    }

    public void addRR(String name, String type, String data) {
        //type must be A, AAAA, CNAME, MX, NS, PTR, SRV, TXT
        addRR(name, type, data, new Integer(60));
    }

    public ArrayList<ResourceRecord> listRRs() {
        //supply a HashMap with keys name, type, or data to filter by value
        //supply nothing to get all records for the domain
        //supply an empty value for name to get records that have no name value
        //  these apply to the base domain only
        return null;
    }

    public void removeRR(String name, String type, String data) {

    }

    public String getInfo() {
        return null;
    }

    public void updateSerial() {

    }
}
