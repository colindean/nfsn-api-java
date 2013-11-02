package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.net.APIResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Member extends APIObject {

    private static final String type = "member";


    public Member(String username, API api) {
        super(username, api, type);
    }

    //properties

    public String getEmail() {
        String path = "/email";
        APIResponse res = executeGetFromPath(path);
        return res.getString();
    }

    public String getPassword() {//this is probably not what it means
        return null;
    }

    public String getStatus() {
        String path = "/status";
        APIResponse res = executeGetFromPath(path);
        return res.getString();
    }

    public ArrayList<Account> getAccounts() {
        String path = "/accounts";
        APIResponse res = executeGetFromPath(path);
        List<String> list = (List)res.getObject();
        ArrayList<Account> output = new ArrayList<Account>(list.size());
        for(String id : list){
            output.add(getAPI().getAccount(id));
        }
        return output;
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

    public void confirmNewEmail(String confirmationCode) {

    }

    public String getAPIKey(String password) {
        return null;
    }

    public String getInfo() {
        return null;
    }

    public void requestNewEmail(String email) {

    }

    public String summarizeAccounts() {
        return null;
    }

    public String summarizeDatabases() {
        return null;
    }

    public String summarizeDomains() {
        return null;
    }

    public String summarizeSites() {
        return null;
    }
}
