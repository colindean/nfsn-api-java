package cx.cad.nfsn;

public class Database extends APIObject {

    private static final String type = "database";

    public Database(String id, API api) {
        super(id, api, type);
    }

    public String getAutoRestart() {
        return null;
    }

    public String getInnoDB() {
        return null;

    }

    public String getType() {
        return null;

    }

    public String getInfo() {
        return null;

    }

    public void start() {

    }

    public void stop() {

    }
}
