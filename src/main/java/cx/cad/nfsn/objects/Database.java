package cx.cad.nfsn.objects;

import cx.cad.nfsn.API;

public class Database extends APIObject {

    private static final String type = "database";

    public Database(String id, API api) {
        super(id, api, type);
    }

    public String getAutoRestart() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public String getInnoDB() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    /**
     * Note that this method name breaks convention because getType() gets the object's type for its URL!
     *
     * @return
     * @throws NFSNNotYetImplementedException
     */
    public String getDatabaseType() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public String getInfo() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public void start() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }

    public void stop() throws NFSNNotYetImplementedException {
        throw new NFSNNotYetImplementedException();
    }
}
