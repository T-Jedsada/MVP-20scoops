package com.pondthaitay.mvp.tweentyscoops.template.activity;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseInterface;

class CustomActivityInterface {

    interface View extends BaseInterface.View {
        void testResult();
    }

    interface Presenter extends BaseInterface.Presenter<CustomActivityInterface.View> {
        void test();
    }
}
