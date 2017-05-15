package com.pondthaitay.mvp.tweentyscoops.ui.showlist.adapter;

import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseListAdapterPresenter;

class ShowListAdapterPresenter extends BaseListAdapterPresenter<ShowListPresenterInterface.Adapter>
        implements ShowListPresenterInterface.Presenter {

    public static ShowListPresenterInterface.Presenter create() {
        return new ShowListAdapterPresenter();
    }

    @Override
    public void test() {

    }
}
