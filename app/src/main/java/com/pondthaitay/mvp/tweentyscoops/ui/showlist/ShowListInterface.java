package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseInterface;

class ShowListInterface {

    interface View extends BaseInterface.View {
        void setBeerItemToAdapter();
    }

    interface Presenter extends BaseInterface.Presenter<ShowListInterface.View> {
        void getListBeer();
    }
}
