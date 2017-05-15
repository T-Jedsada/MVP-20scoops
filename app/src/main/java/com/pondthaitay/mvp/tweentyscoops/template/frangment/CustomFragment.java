package com.pondthaitay.mvp.tweentyscoops.template.frangment;

import android.os.Bundle;
import android.view.View;

import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseFragment;

public class CustomFragment extends BaseFragment<CustomFragmentInterface.Presenter>
        implements CustomFragmentInterface.View {

    public static CustomFragment newInstance() {
        CustomFragment fragment = new CustomFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutToInflate() {
        return 0;
    }

    @Override
    public CustomFragmentInterface.Presenter createPresenter() {
        return CustomFragmentPresenter.create();
    }

    @Override
    protected void startView() {

    }

    @Override
    protected void stopView() {

    }

    @Override
    protected void bindView(View view) {

    }

    @Override
    protected void setupInstance() {

    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void saveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreView(Bundle savedInstanceState) {

    }
}