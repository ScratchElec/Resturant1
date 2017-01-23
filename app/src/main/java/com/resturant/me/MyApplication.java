package com.resturant.me;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Mahmoud Ellawatty on 18/08/2016.
 */
public class MyApplication extends Application {
    public static SharedPreferences preferences;
    @Override
    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences( getPackageName() + "_preferences", MODE_PRIVATE);

    }
}
