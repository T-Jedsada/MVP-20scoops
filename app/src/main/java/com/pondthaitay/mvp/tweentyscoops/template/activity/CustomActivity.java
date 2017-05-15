package com.pondthaitay.mvp.tweentyscoops.template.activity;

import android.os.Bundle;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseActivity;

public class CustomActivity extends BaseActivity<CustomActivityInterface.Presenter>
        implements CustomActivityInterface.View {
    @Override
    public void testResult() {

    }

    @Override
    protected int layoutToInflate() {
        return 0;
    }

    @Override
    public CustomActivityInterface.Presenter createPresenter(){
        return CustomActivityPresenter.create();
    }

    @Override
    protected void startView() {

    }

    @Override
    protected void stopView() {

    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void setupInstance() {

    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void saveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreView(Bundle savedInstanceState) {

    }
}
