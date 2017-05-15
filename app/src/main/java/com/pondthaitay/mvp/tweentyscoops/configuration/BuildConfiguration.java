package com.pondthaitay.mvp.tweentyscoops.configuration;

import com.pondthaitay.mvp.tweentyscoops.BuildConfig;

public class BuildConfiguration implements Config {
    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public String version() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String userToken() {
        return null;
    }
}