package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseInterface;

class ShowListActivityInterface {

    interface View extends BaseInterface.View {
        void setBeerItemToAdapter();
    }

    interface Presenter extends BaseInterface.Presenter<ShowListActivityInterface.View> {
        void getListBeer();
    }
}
