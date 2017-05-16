package com.pondthaitay.mvp.tweentyscoops.ui.main;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.pondthaitay.mvp.tweentyscoops.R;
import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.dao.UserInfoDao;
import com.pondthaitay.mvp.tweentyscoops.api.userinfo.GithubServiceManager;
import com.pondthaitay.mvp.tweentyscoops.manager.Calculator;
import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;
import com.pondthaitay.mvp.tweentyscoops.ui.event.TestBusEvent;

class MainActivityPresenter extends BasePresenter<MainActivityInterface.View> implements MainActivityInterface.Presenter,
        BaseSubscriber.NetworkCallback {

    private GithubServiceManager githubServiceManager;
    private Calculator calculator;

    public static MainActivityInterface.Presenter create() {
        return new MainActivityPresenter();
    }

    MainActivityPresenter() {
        this.githubServiceManager = GithubServiceManager.getInstance();
        this.calculator = Calculator.getInstance();
    }

    void setCalculateManager(Calculator calculateManager) {
        this.calculator = calculateManager;
    }

    void setGithubServiceManager(GithubServiceManager githubServiceManager) {
        this.githubServiceManager = githubServiceManager;
    }

    @Override
    public void plus(String x, String y) {
        if (getView() != null) {
            try {
                getView().showResultPlus(calculator.plus(Integer.parseInt(x), Integer.parseInt(y)));
            } catch (NumberFormatException e) {
                getView().showError(R.string.invalid_number_format);
            }
        }
    }

    @Override
    public void loadUserInfo(String username) {
        if (getView() != null) {
            getView().showProgressDialog();
            githubServiceManager.requestUserInfo(username, this);
        }
    }

    @Override
    public <T> void onSuccess(T t) {
        if (getView() != null) {
            getView().hideProgressDialog();
            getView().showResultUserInfoGitHubApi((UserInfoDao) t);
        }
    }

    @Override
    public void onFailure(String message) {
        if (getView() != null) {
            getView().hideProgressDialog();
            getView().showError(message);
        }
    }

    @Override
    public void onViewCreate() {
        if (getView() != null) getView().showMessage(R.string.view_create);
    }

    @Override
    public void onViewDestroy() {
        if (getView() != null) getView().showMessage(R.string.view_destroy);
    }

    @Override
    public void onViewStart() {
        if (getView() != null) {
            RxBus.get().register(this);
            TestBusEvent event = new TestBusEvent();
            event.setName("Jedsada Tiwongvorakul");
            event.setAge(22);
            RxBus.get().post("tag_test", 555);
            RxBus.get().post(event);
        }
    }

    @Override
    public void onViewStop() {
        if (getView() != null) {
            githubServiceManager.clearDisposable();
            RxBus.get().unregister(this);
        }
    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag("tag_test")})
    void busTestTag(Integer result) {
        if (getView() != null) getView().showResultBusTag(result);
    }

    @Subscribe(thread = EventThread.MAIN_THREAD)
    void busTestObj(TestBusEvent event) {
        if (getView() != null) getView().showResultBusTestBusEvent(event);
    }
}