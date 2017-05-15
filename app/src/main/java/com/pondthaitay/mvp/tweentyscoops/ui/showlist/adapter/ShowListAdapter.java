package com.pondthaitay.mvp.tweentyscoops.ui.showlist.adapter;

import android.view.ViewGroup;

import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseListAdapter;

public class ShowListAdapter extends BaseListAdapter<ShowListViewHolder, ShowListPresenterInterface.Presenter>
        implements ShowListPresenterInterface.Adapter {

    @Override
    public ShowListPresenterInterface.Presenter createPresenter() {
        return ShowListAdapterPresenter.create();
    }

    @Override
    public ShowListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ShowListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void removeItem(int index) {
        super.removeItem(index);
    }

    @Override
    public void test() {
        getPresenter().test();
    }
}
