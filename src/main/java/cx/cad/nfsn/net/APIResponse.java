package cx.cad.nfsn.net;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APIResponse {

    private String jsonString;
    private Boolean status;

    public static Boolean SUCCESS = Boolean.TRUE;
    public static Boolean FAILURE = Boolean.FALSE;

    public APIResponse(String jsonString) {
        this.jsonString = jsonString;
        this.status = SUCCESS;
    }

    public APIResponse(String jsonString, Boolean status) {
        this(jsonString);
        this.status = FAILURE;
    }

    public boolean getStatus(){
        return status;
    }

    public JSONObject mapFromJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }

    public JSONArray arrayFromJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(jsonString);
    }

}
