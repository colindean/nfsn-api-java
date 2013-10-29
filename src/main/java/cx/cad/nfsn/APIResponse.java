package cx.cad.nfsn;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Map;

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

    public Map mapFromJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }

    public ArrayList arrayFromJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(jsonString);
    }

}
