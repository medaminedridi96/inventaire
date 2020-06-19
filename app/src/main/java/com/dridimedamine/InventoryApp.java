package com.dridimedamine;

import android.app.Application;

public class InventoryApp extends Application {

    private static InventoryApp mInstance;

    public static InventoryApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
