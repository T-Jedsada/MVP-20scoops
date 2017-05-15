package com.pondthaitay.mvp.tweentyscoops.ui.showlist.adapter;

import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseListAdapterInterface;

class ShowListPresenterInterface {

    interface Adapter extends BaseListAdapterInterface.Adapter {
        void test();
    }

    interface Presenter extends BaseListAdapterInterface.Presenter<ShowListPresenterInterface.Adapter> {
        void test();
    }
}
