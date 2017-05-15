package com.pondthaitay.mvp.tweentyscoops.template.activity;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;

class CustomActivityPresenter extends BasePresenter<CustomActivityInterface.View> implements CustomActivityInterface.Presenter {

    public static CustomActivityInterface.Presenter create(){
        return new CustomActivityPresenter();
    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewStop() {

    }

    @Override
    public void test() {
        getView().testResult();
    }
}
