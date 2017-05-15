package com.pondthaitay.mvp.tweentyscoops;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

    private static Utils instance;

    public static Utils getInstance() {
        if (instance == null)
            instance = new Utils();
        return instance;
    }

    public boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }

        return false;
    }
}
