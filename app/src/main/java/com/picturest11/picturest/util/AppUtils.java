package com.picturest11.picturest.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Siddharth on 21/11/18.
 */
public class AppUtils {

    private boolean internetConnected = false;

    private AppUtils() {

    }

    private static AppUtils INSTANCE;

    public static AppUtils getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AppUtils();
        }

        return INSTANCE;
    }

    /**
     * Provides internet is connected to mobile or not
     *
     * @param context
     * @return boolean
     */
    public boolean isInternetConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return internetConnected = true;
        }
        else {
            return internetConnected = false;
        }
    }

}
