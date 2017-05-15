package com.pondthaitay.mvp.tweentyscoops.ui.main.frangment;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseInterface;

class MainFragmentInterface {

    interface View extends BaseInterface.View {
        void testResult();
    }

    interface Presenter extends BaseInterface.Presenter<MainFragmentInterface.View> {
        void testFragment();
    }
}
