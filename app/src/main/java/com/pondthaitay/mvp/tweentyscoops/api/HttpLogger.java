package com.pondthaitay.mvp.tweentyscoops.api;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

class HttpLogger implements HttpLoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        final String logName = "OkHttp";
        if (!message.startsWith("{")) {
            Log.d(logName, message);
            return;
        }
        try {
            String prettyPrintJson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(new JsonParser().parse(message));
            Timber.d(prettyPrintJson);
        } catch (JsonSyntaxException m) {
            Timber.e("html header parse failed");
            m.printStackTrace();
            Timber.e(message);
        }
    }
}
