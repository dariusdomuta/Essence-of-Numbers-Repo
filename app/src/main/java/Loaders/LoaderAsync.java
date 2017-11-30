package Loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import Network.NetworkUtils;

/**
 * Created by dariu on 11/22/2017.
 */


public class LoaderAsync extends AsyncTaskLoader<String> {
    private static final String LOG_TAG = LoaderAsync.class.getSimpleName();
    private String mUrl;

    public LoaderAsync(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    @Override
    public String loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        String resultData = NetworkUtils.fetchRequestData(mUrl);
        return resultData;
    }
}
