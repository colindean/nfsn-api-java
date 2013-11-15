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
    public static final String ENCODING = "UTF-8";
    public static final int INPUT_STREAM = 1;
    public static final int ERROR_STREAM = 0;
    public static final String TIMESTAMP_HEADER = "X-NFSN-Timestamp";

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
        APIResponse response = null;

        try {
            connection.setRequestMethod(request.getMethod());
            connection.addRequestProperty(APIRequest.AUTH_HEADER, request.getAuthHeaderValue());
            connection.addRequestProperty("Accept", "application/x-nfsn-api");

            LOGGER.info(String.format("> HTTP %s %s with auth %s",
                    connection.getURL(),
                    connection.getRequestMethod(),
                    connection.getRequestProperty(APIRequest.AUTH_HEADER)));

            int responseCode = connection.getResponseCode();
            switch(responseCode){
                case 200:
                    response = handleSuccess(connection);
                    break;
                case 401:
                    response = handleAuthProblem(connection);
                    break;
                case 403:
                    response = handleForbidden(connection);
                    break;
                case 500:
                    response = handleServerError(connection);
                    break;
                default:
                    response = handledUnexpectedResponseCode(connection);
            }
            // Read the response.

        } catch (Throwable e) {
            try {
                LOGGER.info(String.format("< %d @ %s", connection.getResponseCode(), connection.getHeaderField(TIMESTAMP_HEADER)));
                LOGGER.info(String.format("< %s", IOUtils.toString(connection.getErrorStream(), ENCODING)));

            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            return new APIResponse(exceptionAsJson(e), APIResponse.FAILURE);
        } finally {
            if (connection != null)
                connection.disconnect();

        }
        if(response == null){
            LOGGER.severe("Somehow, no response was parsed. This may not be recoverable!");
        }
        return response;
    }

    public static APIResponse handleSuccess(HttpURLConnection connection) {
        return getApiResponse(connection, INPUT_STREAM);
    }

    private static APIResponse getErrorApiResponse(HttpURLConnection connection) {
        return getApiResponse(connection, ERROR_STREAM);
    }

    public static APIResponse handledUnexpectedResponseCode(HttpURLConnection connection) {
        return getErrorApiResponse(connection);
    }

    public static APIResponse handleServerError(HttpURLConnection connection) {
        return getErrorApiResponse(connection);
    }

    public static APIResponse handleForbidden(HttpURLConnection connection) {
        return getErrorApiResponse(connection);
    }

    public static APIResponse handleAuthProblem(HttpURLConnection connection) {
        return getErrorApiResponse(connection);
    }

    private static APIResponse getApiResponse(HttpURLConnection connection, int streamSelect) {
        InputStream stream = null;
        String response = "";
        try {
            if(streamSelect == INPUT_STREAM)
                stream = connection.getInputStream();
            else
                stream = connection.getErrorStream();

            response = IOUtils.toString(stream, ENCODING);
            LOGGER.info(String.format("< %d @ %s", connection.getResponseCode(), connection.getHeaderField(TIMESTAMP_HEADER)));
            LOGGER.info(response);
        } catch (IOException e) {
            //things that could go wrong:
            // * getInputStream() could fail
            // * stream -> string could fail
            // * getResponseCode could fail
            LOGGER.severe("Unable to convert response to a string. Something could be seriously wrong with the endpoint.");
            e.printStackTrace();
        } finally {
            if (stream != null) try {
                stream.close();
            } catch (IOException e) {
                LOGGER.warning("Encountered " + e + " while closing the request error stream.");
            }
        }
        boolean status = streamSelect == INPUT_STREAM ? APIResponse.SUCCESS : APIResponse.FAILURE;
        return new APIResponse(response, status);
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
