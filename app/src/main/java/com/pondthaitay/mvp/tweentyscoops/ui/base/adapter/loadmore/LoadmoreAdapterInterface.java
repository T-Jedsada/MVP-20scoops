package com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.loadmore;

import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseItem;
import com.pondthaitay.mvp.tweentyscoops.ui.base.adapter.BaseListAdapterInterface;

import java.util.List;

public interface LoadmoreAdapterInterface {

    interface Adapter extends BaseListAdapterInterface.Adapter {
    }

    interface Presenter<A extends LoadmoreAdapterInterface.Adapter>
            extends BaseListAdapterInterface.Presenter<A> {
        void setItems(List<BaseItem> items, boolean isNextItemAvailable);
    }
}

