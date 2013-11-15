package cx.cad.nfsn.models;

import org.json.simple.JSONObject;

public class ResourceRecord {

    public String name;
    public String type;
    public String data;
    public Long ttl;

    public ResourceRecord(String name, String type, String data, Long ttl){
        this.name = name;
        this.type = type;
        this.data = data;
        this.ttl = ttl;
    }

    public static ResourceRecord newFromMap(JSONObject record) {
        return new ResourceRecord(
                (String)record.get("name"),
                (String)record.get("type"),
                (String)record.get("data"),
                (Long)record.get("ttl"));
    }
}
