package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;

/**
 * Created by albertlardizabal on 1/15/17.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
