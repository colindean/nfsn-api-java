package cx.cad.nfsn.net;

import com.squareup.okhttp.OkHttpClient;
import cx.cad.nfsn.API;
import cx.cad.nfsn.utilities.InformationNeededException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.logging.Logger;

public class APIExecutor {

    private static final Logger LOGGER = Logger.getLogger(APIExecutor.class.toString());

    public static APIResponse executeRequest(APIRequest request) {
        try {
            return executeRequest(request, getConnectionForPath(request.getPath()));
        } catch(MalformedURLException e){
            return new APIResponse(exceptionAsJson(e));
        }
    }

    public static HttpURLConnection getConnectionForPath(String path) throws MalformedURLException {
        URL url = buildRequestUrl(path);
        return new OkHttpClient().open(url);
    }

    public static APIResponse executeRequest(APIRequest request, HttpURLConnection connection){
        InputStream in = null;
        try {
            connection.setRequestMethod(request.getMethod());
            connection.addRequestProperty(APIRequest.AUTH_HEADER, request.getAuthHeaderValue());
            // Read the response.
            in = connection.getInputStream();
            String jsonResponse = IOUtils.toString(in, "UTF-8");
            return new APIResponse(jsonResponse);
        } catch (Throwable e) {
            return new APIResponse(exceptionAsJson(e), APIResponse.FAILURE);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                LOGGER.warning("Encountered " + e + " while closing the request input stream.");
            }
            if (connection != null)
                connection.disconnect();

        }
    }

    public static URL buildRequestUrl(String path) throws MalformedURLException {
        StringBuilder url = new StringBuilder();
        url.append(API.PROTOCOL).append("://").append(API.DOMAIN);
        url.append(path);
        return new URL(url.toString());
    }

    public static String exceptionAsJson(Throwable e) {
        return "{\"error\": \"" + e.toString() + "\"}";
    }
}
