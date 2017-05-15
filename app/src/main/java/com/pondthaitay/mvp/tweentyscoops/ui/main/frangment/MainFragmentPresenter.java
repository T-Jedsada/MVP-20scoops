package com.pondthaitay.mvp.tweentyscoops.ui.main.frangment;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;

class MainFragmentPresenter extends BasePresenter<MainFragmentInterface.View>
        implements MainFragmentInterface.Presenter {

    public static MainFragmentInterface.Presenter create() {
        return new MainFragmentPresenter();
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
    public void testFragment() {
        getView().testResult();
    }
}
