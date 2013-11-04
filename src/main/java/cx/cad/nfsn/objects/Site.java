package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;

import java.util.ArrayList;

public class Site extends APIObject {

    private static final String type = "site";


    public Site(String shortName, API api) {
        super(shortName, api, type);
    }

    //no properties?

    //methods

    public void addAlias(String alias) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public void removeAlias(String alias) throws NotYetImplementedHereException {
        throw new NotYetImplementedHereException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public ArrayList<String> listBandwidthActivity(Integer days) throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public ArrayList<String> listStorageActivity(Integer days) throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

}
