package com.pondthaitay.mvp.tweentyscoops.ui.main;

import com.pondthaitay.mvp.tweentyscoops.api.dao.UserInfoDao;
import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseInterface;
import com.pondthaitay.mvp.tweentyscoops.ui.event.TestBusEvent;

class MainActivityInterface {

    public interface View extends BaseInterface.View {
        void showResultPlus(int result);

        void showResultUserInfoGitHubApi(UserInfoDao dao);

        void showResultBusTag(int result);

        void showResultBusTestBusEvent(TestBusEvent event);
    }

    public interface Presenter extends BaseInterface.Presenter<MainActivityInterface.View> {
        void plus(String x, String y);

        void loadUserInfo(String username);
    }
}