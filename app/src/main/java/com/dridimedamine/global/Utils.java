package com.dridimedamine.global;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.Nullable;

public class Utils {

    /**
     * check if user is connected to the Internet
     */
    public static boolean isNetworkAvailable(@Nullable Context context) {

        if (context != null) {

            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected();

        }

        return false;
    }
}
