package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.models.ResourceRecord;
import cx.cad.nfsn.net.APIResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DNS extends APIObject {

    private static final String type = "dns";
    public static final Map<String, String> NO_LIMITATIONS = null;


    public DNS(String domain, API api) {
        super(domain, api, type);
    }

    //properties

    public Long getExpire() {
        String path = "/balance";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }

    public void setExpire(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be between 86400 and 2678400
        //must be >= refresh and retry values
        throw new NotYetImplementedHereException();
    }

    public Long getMinTTL() {
        String path = "/minTTL";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }

    public void setMinTTL(Integer seconds) throws NotYetImplementedHereException {
        //put
        //min 60, max 2678400
        throw new NotYetImplementedHereException();
    }

    public Long getRefresh() {
        String path = "/refresh";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }

    public void setRefresh(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be >= minTTL
        //must be <= expire
        throw new NotYetImplementedHereException();
    }

    public Long getRetry() {
        String path = "/retry";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }

    public void setRetry(Integer seconds) throws NotYetImplementedHereException {
        //put
        //must be >= 60
        //must be <= expire
        throw new NotYetImplementedHereException();
    }

    public Long getSerial() {
        String path = "/serial";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }

    //methods

    public void addRR(String name, String type, String data, Integer seconds) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void addRR(String name, String type, String data) throws NotYetImplementedHereException {
        //type must be A, AAAA, CNAME, MX, NS, PTR, SRV, TXT
        addRR(name, type, data, 60);
    }

    /**
     * List all resource records matching the supplied limitations.
     * <p/>
     * name - Limit results to those matching this name. (Optional)
     * type - Limit results to those matching this type. (Optional)
     * data - Limit results to those matching this data value. (Optional)
     * <p/>
     * Pass NO_LIMITATIONS to get all records
     * <p/>
     * Specify a "name" key with an empty value to return only those records that have no name value
     * (i.e., those that apply to the "base" domain name).
     *
     * @param limitations Key matching one of the above types, value is what the match should be
     * @return resource records matching limitations, or all resource records for the domain if passed NO_LIMITATIONS
     */
    public ArrayList<ResourceRecord> listRRs(Map<String, String> limitations) {
        String path = "/listRRs";
        APIResponse res = executeGetFromPath(path);
        List<JSONObject> list = res.getList();
        ArrayList<ResourceRecord> output = new ArrayList<ResourceRecord>(list.size());
        for (JSONObject record : list) {
            output.add(ResourceRecord.newFromMap(record));
        }
        return output;
    }

    public void removeRR(String name, String type, String data) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public Long updateSerial() {
        String path = "/updateSerial";
        APIResponse res = executeGetFromPath(path);
        return res.getLong();
    }
}
