package com.pondthaitay.mvp.tweentyscoops.ui.base.adapter;

import android.support.v7.widget.RecyclerView;

import com.pondthaitay.mvp.tweentyscoops.ui.base.exception.MvpPresenterNotCreateException;

import java.util.List;

public abstract class BaseListAdapter<VH extends BaseViewHolder, P extends BaseListAdapterInterface.Presenter>
        extends RecyclerView.Adapter<VH> implements BaseListAdapterInterface.Adapter {

    private P presenter;

    public abstract P createPresenter();

    protected interface OnLoadMoreListener {
        void onLoadMore();
    }

    @SuppressWarnings("unchecked")
    public BaseListAdapter() {
        presenter = createPresenter();
        presenter.setAdapter(this);
    }

    @Override
    public P getPresenter() {
        if (presenter != null) return presenter;
        throw new MvpPresenterNotCreateException();
    }

    @SuppressWarnings("unchecked")
    public List<BaseItem> getItems() {
        return getPresenter().getItems();
    }

    public BaseItem getItem(int pos) {
        return getPresenter().getItem(pos);
    }

    public boolean hasItems() {
        return getPresenter().hasItems();
    }

    public void setItems(List<BaseItem> items) {
        getPresenter().setItems(items);
    }

    public void addItem(BaseItem item) {
        getPresenter().addItem(item);
    }

    public void removeItem(int index) {
        getPresenter().removeItem(index);
    }

    public void removeAllItems() {
        getPresenter().removeAllItems();
    }
}
