package cx.cad.nfsn.net;

import com.squareup.okhttp.OkHttpClient;
import cx.cad.nfsn.API;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class APIExecutor {

    private static final Logger LOGGER = Logger.getLogger(APIExecutor.class.toString());

    public static APIResponse executeRequest(APIRequest request) {
        try {
            return executeRequest(request, getConnectionForPath(request.getPath()));
        } catch (MalformedURLException e) {
            return new APIResponse(exceptionAsJson(e));
        }
    }

    public static HttpURLConnection getConnectionForPath(String path) throws MalformedURLException {
        URL url = buildRequestUrl(path);
        OkHttpClient client = new OkHttpClient();
        // Ignore invalid SSL endpoints.
        client.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        return client.open(url);
    }

    public static APIResponse executeRequest(APIRequest request, HttpURLConnection connection) {
        InputStream in = null;
        try {
            connection.setRequestMethod(request.getMethod());
            connection.addRequestProperty(APIRequest.AUTH_HEADER, request.getAuthHeaderValue());

            LOGGER.info(String.format("> HTTP %s %s with auth %s",
                    connection.getURL(),
                    connection.getRequestMethod(),
                    connection.getRequestProperty(APIRequest.AUTH_HEADER)));

            // Read the response.
            in = connection.getInputStream();
            String jsonResponse = IOUtils.toString(in, "UTF-8");
            LOGGER.info(String.format("< %d %s", connection.getResponseCode(), jsonResponse));
            return new APIResponse(jsonResponse);
        } catch (Throwable e) {
            try {
                LOGGER.info(String.format("< %d %s", connection.getResponseCode(), connection.getResponseMessage()));
                LOGGER.info(String.format("< %s", IOUtils.toString(connection.getErrorStream(), "UTF-8")));

            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

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
