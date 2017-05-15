package com.pondthaitay.mvp.tweentyscoops;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import butterknife.ButterKnife;
import timber.log.Timber;

public class MyApplication extends Application {

    @SuppressLint("ObsoleteSdkInt")
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                threadPolicyBuilder.penaltyDeathOnNetwork();
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
        }
    }
}