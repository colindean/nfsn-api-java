package cx.cad.nfsn.net;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Logger;

public class APIResponse {

    private static final String PARSE_EXCEPTION_ERROR_JSONSTRING = "{\"error\":\"Failed to parse JSON response\"}";
    private String jsonString;
    private Boolean status;
    private JSONObject jsonObject;

    private final Logger LOGGER = Logger.getLogger(APIResponse.class.toString());

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

    public boolean isError(){
        return getJson().containsKey("error");
    }

    public String getDebugMessage(){
          return (String) getJson().get("debug");
    }
    public String getError(){
        return (String) getJson().get("error");
    }

    public JSONObject getJson() {
        if(jsonObject == null){
            try {
              jsonObject = parse(jsonString);
            } catch (ParseException e) {
                LOGGER.severe(String.format("%s: Failed to parse JSON response: %s", e.getMessage(), jsonString));
                try {
                    jsonObject = parse(PARSE_EXCEPTION_ERROR_JSONSTRING);
                } catch (ParseException e1) {
                    LOGGER.severe(String.format("%s: Failed to parse canned JSON error response: %s",
                            e.getMessage(), PARSE_EXCEPTION_ERROR_JSONSTRING));
                }
            }
        }
        return jsonObject;
    }

    private JSONObject parse(String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }

    //TODO: determine if this is needed
    private JSONArray arrayFromJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(jsonString);
    }

}
