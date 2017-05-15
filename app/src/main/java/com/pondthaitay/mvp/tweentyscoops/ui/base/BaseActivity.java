package com.pondthaitay.mvp.tweentyscoops.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.pondthaitay.mvp.tweentyscoops.R;
import com.pondthaitay.mvp.tweentyscoops.ui.base.exception.MvpNotSetLayoutException;
import com.pondthaitay.mvp.tweentyscoops.ui.base.exception.MvpPresenterNotCreateException;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BaseInterface.Presenter> extends AppCompatActivity
        implements BaseInterface.View {

    private P presenter;

    @Nullable
    @BindView(android.R.id.content)
    android.view.View contentView;

    private ProgressDialog progressDialog;

    @LayoutRes
    protected abstract int layoutToInflate();

    public abstract P createPresenter();

    protected abstract void startView();

    protected abstract void stopView();

    protected abstract void bindView();

    protected abstract void setupInstance();

    protected abstract void setupView();

    protected abstract void initialize();

    protected abstract void saveInstanceState(Bundle outState);

    public abstract void restoreView(Bundle savedInstanceState);

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutToInflate() == 0) throw new MvpNotSetLayoutException();
        setContentView(layoutToInflate());
        ButterKnife.bind(this);
        presenter = createPresenter();
        presenter.attachView(this);
        bindView();
        setupInstance();
        setupView();
        setupProgressDialog();
        getPresenter().onViewCreate();
        if (savedInstanceState == null) initialize();
    }

    @Override
    public P getPresenter() {
        if (presenter != null) return presenter;
        throw new MvpPresenterNotCreateException();
    }

    @Override
    public void showProgressDialog() {
        if (!progressDialog.isShowing()) progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void showError(String errorMessage) {
        showSnackBar(errorMessage);
    }

    @Override
    public void showError(@StringRes int errorMessage) {
        showSnackBar(getString(errorMessage));
    }

    @Override
    public void showMessage(String message) {
        showSnackBar(message);
    }

    @Override
    public void showMessage(@StringRes int message) {
        showSnackBar(getString(message));
    }

    @Override
    public void unAuthorizedApi() {
        showSnackBar(getResources().getString(R.string.un_authorize_api));
    }

    @Override
    protected void onStart() {
        super.onStart();
        startView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) progressDialog.cancel();
        getPresenter().onViewDestroy();
        presenter.detachView();
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getString(R.string.loading));
    }

    private void showSnackBar(@NonNull String message) {
        if (contentView != null) Snackbar.make(contentView, message, Snackbar.LENGTH_SHORT).show();
    }
}