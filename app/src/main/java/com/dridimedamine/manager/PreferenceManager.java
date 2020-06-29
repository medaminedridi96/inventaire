package com.dridimedamine.manager;

import android.content.SharedPreferences;

import com.dridimedamine.InventoryApp;

public class PreferenceManager {
    private static final String FILE_NAME_FLAG = "preference_file_name";

    private static PreferenceManager mInstance;
    private SharedPreferences mSharedPreferences;

    private PreferenceManager() {
        mSharedPreferences = InventoryApp.getInstance().getSharedPreferences(FILE_NAME_FLAG, 0);
    }

    public static PreferenceManager getInstance() {
        if (mInstance == null) {

            mInstance = new PreferenceManager();
        }

        return mInstance;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void put(String key, Boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void getString(String key) {
        mSharedPreferences.getString(key, "");
    }
}
