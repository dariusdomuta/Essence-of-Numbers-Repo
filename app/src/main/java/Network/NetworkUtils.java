package Network;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by dariu on 11/22/2017.
 */

public class NetworkUtils {

    public static final String LOG_TAG = NetworkUtils.class.getName();

    private NetworkUtils(){
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try{
            url = new URL(stringUrl);
        } catch (MalformedURLException e){
            Log.e(LOG_TAG, "@string/url_error", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static String fetchRequestData(String stringUrl){

        URL url = createUrl(stringUrl);
        String result = null;
        try{
            result = makeHttpRequest(url);
        } catch (IOException e){
            Log.e(LOG_TAG, "Problem making HTTP request.", e);
        }
        return result;

    }
}
