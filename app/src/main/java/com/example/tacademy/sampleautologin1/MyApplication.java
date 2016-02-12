package com.example.tacademy.sampleautologin1;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tacademy on 2016-02-12.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
