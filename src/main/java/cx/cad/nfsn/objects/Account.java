package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.models.AccountStatus;
import cx.cad.nfsn.net.APIResponse;

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

    public void setFriendlyName(String name) throws NotYetImplementedHereException {
        String path = "/friendlyName";
        //put
        throw new NotYetImplementedHereException();
    }

    public AccountStatus getStatus() {
        //returns json with status, short, and color in hex
        String path = "/status";
        APIResponse res = executeGetFromPath(path);
        return AccountStatus.newFromMap(res.getJsonObject());
    }

    public ArrayList<Site> getSites() {
        String path = "/sites";
        APIResponse res = executeGetFromPath(path);
        List<String> list = res.getList();
        ArrayList<Site> output = new ArrayList<Site>(list.size());
        for (String id : list) {
            output.add(getAPI().getSite(id));
        }
        return output;
    }

    //methods

    public Site addSite(String shortName) throws NotYetImplementedHereException {
        String path = "/addSite";
        throw new NotYetImplementedHereException();
    }

    public void addWarning(Integer cents) throws NotYetImplementedHereException {
        //send the cents div 100 as a string
        String path = "/addWarning";
        throw new NotYetImplementedHereException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        String path = "/getInfo";
        throw new NFSNNotYetImplementedException();
    }

    public String listActivityCurrent() throws NFSNNotYetImplementedException {
        String path = "/listActivityCurrent";
        throw new NFSNNotYetImplementedException();
    }

    public String listActivityOld() throws NFSNNotYetImplementedException {
        String path = "/listActivityOld";
        throw new NFSNNotYetImplementedException();
    }

    public void removeWarning(Integer cents) throws NotYetImplementedHereException {
        String path = "/removeWarning";
        throw new NotYetImplementedHereException();

    }

}
