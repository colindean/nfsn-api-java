package cx.cad.nfsn;

import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class APIResponse {

  public Map mapFromJson(){
    JSONParser parser = new JSONParser();
    Map map = (JSONObject)parser.parse(responseBody);
    return map;
  }

  public ArrayList arrayFromJson(){
    JSONParser parser = new JSONParser();
    return new ArrayList( (JSONArray) parser.parse(responseBody));
  }

}
