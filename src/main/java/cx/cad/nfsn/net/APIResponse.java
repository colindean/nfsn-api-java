package cx.cad.nfsn.net;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Logger;

public class APIResponse {

    private static final String PARSE_EXCEPTION_ERROR_JSONSTRING = "{\"error\":\"Failed to parse JSON response\"}";
    private String responseString;
    private Boolean status;
    private Object parsedObject;

    private final Logger LOGGER = Logger.getLogger(APIResponse.class.toString());

    public static Boolean SUCCESS = Boolean.TRUE;
    public static Boolean FAILURE = Boolean.FALSE;

    public APIResponse(String responseString) {
        this.responseString = responseString;
        this.status = SUCCESS;
    }

    public APIResponse(String responseString, Boolean status) {
        this(responseString);
        this.status = FAILURE;
    }

    public boolean getStatus(){
        return status;
    }

    public boolean isError(){
        return getJsonObject().containsKey("error");
    }

    public String getDebugMessage(){
        return (String) getJsonObject().get("debug");
    }
    public String getError(){
        return (String) getJsonObject().get("error");
    }

    public Object getObject() {
        if(parsedObject == null){
            try {
                parsedObject = parse(responseString);
            } catch (ParseException e) {
                LOGGER.severe(String.format("%s: Failed to parse JSON response: %s", e.getMessage(), responseString));
                try {
                    parsedObject = parse(PARSE_EXCEPTION_ERROR_JSONSTRING);
                } catch (ParseException e1) {
                    LOGGER.severe(String.format("%s: Failed to parse canned JSON error response: %s",
                            e.getMessage(), PARSE_EXCEPTION_ERROR_JSONSTRING));
                }
            }
        }
        return parsedObject;
    }

    public JSONObject getJsonObject(){
        return (JSONObject) getObject();
    }

    public Double getDouble(){
        return (Double) getObject();
    }

    public String getString(){
        return (String) getObject();
    }

    private Object parse(String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        return parser.parse(jsonString);
    }

}
