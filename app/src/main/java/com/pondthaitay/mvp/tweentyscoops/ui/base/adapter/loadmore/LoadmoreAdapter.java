package com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.loadmore;

import android.view.ViewGroup;

import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseItem;
import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseItemType;
import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseListAdapter;
import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseViewHolder;
import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.progress.ProgressHolder;

import java.util.List;

public abstract class LoadmoreAdapter<VH extends BaseViewHolder, P extends LoadmoreAdapterInterface.Presenter>
        extends BaseListAdapter<VH, P>
        implements LoadmoreAdapterInterface.Adapter {

    private OnLoadMoreListener loadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener listener) {
        this.loadMoreListener = listener;
    }

    public void setItems(List<BaseItem> items, boolean isNextItemAvailable) {
        getPresenter().setItems(items, isNextItemAvailable);
    }

    @SuppressWarnings("unchecked")
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BaseItemType.TYPE_PROGRESS) {
            return (VH) new ProgressHolder(parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (getItemViewType(position) == BaseItemType.TYPE_PROGRESS) {
            if (loadMoreListener != null) {
                loadMoreListener.onLoadMore();
            }
        }
    }
}
