package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.models.AccountStatus;
import cx.cad.nfsn.net.APIResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Account extends APIObject {

    private static final String type = "account";

    public Account(String id, API api) {
        super(id, api, type);
    }

    //properties

    public Double getBalance() {
        String path = "/balance";
        APIResponse res = executeGetFromPath(path);
        return (Double) res.getObject();
    }

    public Integer getBalanceCash() {
        String path = "/balanceCash";
        return null;
    }

    public Integer getBalanceCredit() {
        String path = "/balanceCredit";
        return null;
    }

    public Integer getBalanceHigh() {
        String path = "/balanceHigh";
        return null;
    }

    public String getFriendlyName() {
        String path = "/friendlyName";
        return null;
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
        return null;
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
