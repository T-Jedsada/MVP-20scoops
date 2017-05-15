package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.pondthaitay.mvp.tweentyscoops.R;
import com.pondthaitay.mvp.tweentyscoops.ui.base.BaseActivity;
import com.pondthaitay.mvp.tweentyscoops.ui.showlist.adapter.ShowListAdapter;

import butterknife.BindView;

public class ShowListActivity extends BaseActivity<ShowListInterface.Presenter>
        implements ShowListInterface.View {

    @BindView(R.id.list)
    RecyclerView list;

    @Override
    protected int layoutToInflate() {
        return R.layout.activity_show_list;
    }

    @Override
    public ShowListInterface.Presenter createPresenter() {
        return ShowListActivityPresenter.create();
    }

    @Override
    protected void startView() {

    }

    @Override
    protected void stopView() {

    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void setupInstance() {
        ShowListAdapter adapter = new ShowListAdapter();
        list.setAdapter(adapter);
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initialize() {
//        getPresenter().getListBeer();
    }

    @Override
    protected void saveInstanceState(Bundle outState) {

    }

    @Override
    public void restoreView(Bundle savedInstanceState) {

    }

    @Override
    public void setBeerItemToAdapter() {

    }
}
