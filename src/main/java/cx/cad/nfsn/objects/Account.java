package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.models.AccountStatus;
import cx.cad.nfsn.net.APIResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Account extends APIObject {

    private static final String type = "account";

    public Account(String id, API api) {
        super(id, api, type);
    }

    //properties

    public Double getBalance() {
        String path = "/balance";
        APIResponse res = executeGetFromPath(path);
        return res.getDouble();
    }

    public Double getBalanceCash() {
        String path = "/balanceCash";
        APIResponse res = executeGetFromPath(path);
        return res.getDouble();
    }

    public Double getBalanceCredit() {
        String path = "/balanceCredit";
        APIResponse res = executeGetFromPath(path);
        return res.getDouble();
    }

    public Double getBalanceHigh() {
        String path = "/balanceHigh";
        APIResponse res = executeGetFromPath(path);
        return res.getDouble();
    }

    public String getFriendlyName() {
        String path = "/friendlyName";
        APIResponse res = executeGetFromPath(path);
        return res.getString();
    }

    public void setFriendlyName(String name) {
        String path = "/friendlyName";
        //put
    }

    public AccountStatus getStatus() {
        //returns json with status, short, and color in hex
        String path = "/status";
        return AccountStatus.newFromMap((JSONObject)executeGetFromPath(path).getObject());
    }

    public ArrayList<Site> getSites() {
        String path = "/sites";
        APIResponse res = executeGetFromPath(path);
        List<String> list = (List)res.getObject();
        ArrayList<Site> output = new ArrayList<Site>(list.size());
        for(String id : list){
            output.add(getAPI().getSite(id));
        }
        return output;
    }

    //methods

    public Site addSite(String shortName) {
        return null;
    }

    public void addWarning(Integer cents) {
        //send the cents div 100 as a string
    }

    public String getInfo() {
        return null;
    }

    public String listActivityCurrent() {
        return null;
    }

    public String listActivityOld() {
        return null;
    }

    public void removeWarning(Integer cents) {

    }

}
