package cx.cad.nfsn.net;

import com.squareup.okhttp.OkHttpClient;
import cx.cad.nfsn.API;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class APIExecutor {

    private static final Logger LOGGER = Logger.getLogger(APIExecutor.class.toString());

    public static APIResponse executeRequest(APIRequest request){
        OkHttpClient client = new OkHttpClient();

        HttpURLConnection con = null;
        InputStream in = null;
        try {
            URL url = buildRequestUrl(request.getPath());
            con = client.open(url);
            con.setRequestMethod(request.getMethod());
            // Read the response.
            in = con.getInputStream();
            String jsonResponse = IOUtils.toString(in, "UTF-8");
            return new APIResponse(jsonResponse);
        } catch (Exception e) {
            return new APIResponse(exceptionAsJson(e), APIResponse.FAILURE);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                LOGGER.warning("Encountered " + e + " while closing the request input stream.");
            }
        }
    }

    public static URL buildRequestUrl(String path) throws MalformedURLException {
        StringBuilder url = new StringBuilder();
        url.append(API.PROTOCOL).append("://").append(API.DOMAIN);
        url.append(path);
        return new URL(url.toString());
    }

    private static String exceptionAsJson(Exception e) {
        return "{error: \"" + e.toString() + "\"}";
    }
}
