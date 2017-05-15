package com.pondthaitay.mvp.tweentyscoops.ui.base;

import android.support.annotation.StringRes;

public class BaseInterface {

    public interface UnAuthorizedCallback {
        void onUnAuthorized();
    }

    public interface View {

        Presenter getPresenter();

        void showProgressDialog();

        void hideProgressDialog();

        void showError(String message);

        void showError(@StringRes int message);

        void showMessage(String message);

        void showMessage(@StringRes int message);

        void unAuthorizedApi();
    }

    public interface Presenter<V extends BaseInterface.View> {

        void attachView(V view);

        void detachView();

        V getView();

        void onViewCreate();

        void onViewDestroy();

        void onViewStart();

        void onViewStop();
    }
}