package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;
import cx.cad.nfsn.net.APIResponse;

import java.util.ArrayList;
import java.util.List;

public class Member extends APIObject {

    private static final String type = "member";


    public Member(String username, API api) {
        super(username, api, type);
    }

    //properties

    public String getEmail() throws NFSNNotYetImplementedException {
        String path = "/email";
        APIResponse res = executeGetFromPath(path);
        return res.getString();
    }

    public String getPassword() {//this is probably not what it means
        return null;
    }

    public String getStatus() throws NFSNNotYetImplementedException {
        String path = "/status";
        APIResponse res = executeGetFromPath(path);
        return res.getString();
    }

    public ArrayList<Account> getAccounts() {
        String path = "/accounts";
        APIResponse res = executeGetFromPath(path);
        List<String> list = (List) res.getObject();
        ArrayList<Account> output = new ArrayList<Account>(list.size());
        for (String id : list) {
            output.add(getAPI().getAccount(id));
        }
        return output;
    }

    public ArrayList<Site> getSites() {
        String path = "/sites";
        APIResponse res = executeGetFromPath(path);
        List<String> list = (List) res.getObject();
        ArrayList<Site> output = new ArrayList<Site>(list.size());
        for (String id : list) {
            output.add(getAPI().getSite(id));
        }
        return output;
    }

    //methods

    public void confirmNewEmail(String confirmationCode) throws NFSNNotYetImplementedException {
        String path = "/confirmNewEmail";
        throw new NFSNNotYetImplementedException();
    }

    public String getAPIKey(String password) throws NFSNNotYetImplementedException {
        String path = "/getAPIKey";
        throw new NFSNNotYetImplementedException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        String path = "/getInfo";
        throw new NFSNNotYetImplementedException();
    }

    public void requestNewEmail(String email) throws NFSNNotYetImplementedException {
        String path = "/requestNewEmail";
        throw new NFSNNotYetImplementedException();
    }

    public String summarizeAccounts() throws NFSNNotYetImplementedException {
        String path = "/summarizeAccounts";
        throw new NFSNNotYetImplementedException();
    }

    public String summarizeDatabases() throws NFSNNotYetImplementedException {
        String path = "/summarizeDatabases";
        throw new NFSNNotYetImplementedException();
    }

    public String summarizeDomains() throws NFSNNotYetImplementedException {
        String path = "/summarizeDomains";
        throw new NFSNNotYetImplementedException();
    }

    public String summarizeSites() throws NFSNNotYetImplementedException {
        String path = "/summarizeSites";
        throw new NFSNNotYetImplementedException();
    }
}
