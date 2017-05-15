package com.pondthaitay.mvp.tweentyscoops.template.frangment;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;

class CustomFragmentPresenter extends BasePresenter<CustomFragmentInterface.View>
        implements CustomFragmentInterface.Presenter {

    public static CustomFragmentInterface.Presenter create(){
        return new CustomFragmentPresenter();
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
}
