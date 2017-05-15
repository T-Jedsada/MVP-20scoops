package com.pondthaitay.mvp.tweentyscoops.ui.base;

import com.pondthaitay.mvp.tweentyscoops.ui.base.exception.MvpViewNotAttachedException;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseInterface.View>
        implements BaseInterface.UnAuthorizedCallback, BaseInterface.Presenter<V> {

    private WeakReference<V> view;

    @Override
    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public V getView() {
        if (view != null) return view.get();
        throw new MvpViewNotAttachedException();
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

    @Override
    public void onUnAuthorized() {
        if (view != null) {
            view.get().hideProgressDialog();
            view.get().unAuthorizedApi();
        }
    }
}