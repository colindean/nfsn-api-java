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

    public Integer getExpire() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void setExpire(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be between 86400 and 2678400
        //must be >= refresh and retry values
        throw new NotYetImplementedHereException();
    }

    public Integer getMinTTL() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void setMinTTL(Integer seconds) throws NotYetImplementedHereException {
        //put
        //min 60, max 2678400
        throw new NotYetImplementedHereException();
    }

    public Integer getRefresh() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void setRefresh(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be >= minTTL
        //must be <= expire
        throw new NotYetImplementedHereException();
    }

    public Integer getRetry() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void setRetry(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be >= 60
        //must be <= expire
        throw new NotYetImplementedHereException();
    }

    public Integer getSerial() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    //methods

    public void addRR(String name, String type, String data, Integer seconds) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void addRR(String name, String type, String data) throws NotYetImplementedHereException {
        //type must be A, AAAA, CNAME, MX, NS, PTR, SRV, TXT
        addRR(name, type, data, new Integer(60));
    }

    public ArrayList<ResourceRecord> listRRs() throws NotYetImplementedHereException {
        //supply a HashMap with keys name, type, or data to filter by value
        //supply nothing to get all records for the domain
        //supply an empty value for name to get records that have no name value
        //  these apply to the base domain only
        throw new NotYetImplementedHereException();
    }

    public void removeRR(String name, String type, String data) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public void updateSerial() throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }
}
